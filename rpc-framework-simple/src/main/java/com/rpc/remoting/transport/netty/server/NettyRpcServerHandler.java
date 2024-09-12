package com.rpc.remoting.transport.netty.server;

import com.rpc.enums.CompressTypeEnum;
import com.rpc.enums.RpcResponseCodeEnum;
import com.rpc.enums.SerializationTypeEnum;
import com.rpc.factory.SingletonFactory;
import com.rpc.remoting.constants.RpcConstants;
import com.rpc.remoting.dto.RpcMessage;
import com.rpc.remoting.dto.RpcRequest;
import com.rpc.remoting.dto.RpcResponse;
import com.rpc.remoting.handler.RpcRequestHandler;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: djc
 * @Date: 2024-09-12-12:31
 * @Description:
 */

@Slf4j
@Component
public class NettyRpcServerHandler extends ChannelInboundHandlerAdapter {
    private final RpcRequestHandler rpcRequestHandler;

    public NettyRpcServerHandler() {
        this.rpcRequestHandler = SingletonFactory.getInstance(RpcRequestHandler.class);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try{
            if(msg instanceof RpcRequest){
                log.info("server receive msg:[{}]",msg);
                byte messageType=((RpcMessage) msg).getMessageType();
                RpcMessage rpcMessage=new RpcMessage();
                rpcMessage.setCodec(SerializationTypeEnum.KRYO.getCode());
                rpcMessage.setCompress(CompressTypeEnum.GZIP.getCode());
                if(messageType== RpcConstants.HEARTBEAT_RSPONSE_TYPE){
                    rpcMessage.setMessageType(RpcConstants.HEARTBEAT_RSPONSE_TYPE);
                    rpcMessage.setData(RpcConstants.PONG);
                }else{
                    RpcRequest request = (RpcRequest) ((RpcMessage) msg).getData();
                    Object result = rpcRequestHandler.handle(request);
                    rpcMessage.setMessageType(RpcConstants.RESPONSE_TYPE);
                    if(ctx.channel().isActive()&& ctx.channel().isWritable()){
                        RpcResponse<Object> response=RpcResponse.success(result,request.getRequestId());
                        rpcMessage.setData(response);
                    }else{
                        RpcResponse<Object> rpcResponse = RpcResponse.fail(RpcResponseCodeEnum.FAIL);
                        rpcMessage.setData(rpcResponse);
                        log.error("not writable now, message dropped");
                    }
                }
                ctx.writeAndFlush(rpcMessage).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            }
        }finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleState state = ((IdleStateEvent) evt).state();
            if (state == IdleState.READER_IDLE) {
                log.info("idle check happen, so close the connection");
                ctx.close();
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("server catch exception");
        cause.printStackTrace();
        ctx.close();
    }
}
