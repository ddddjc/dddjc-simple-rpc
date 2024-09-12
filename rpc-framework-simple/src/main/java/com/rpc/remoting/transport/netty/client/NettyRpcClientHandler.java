package com.rpc.remoting.transport.netty.client;

import com.rpc.factory.SingletonFactory;
import com.rpc.remoting.constants.RpcConstants;
import com.rpc.remoting.dto.RpcMessage;
import com.rpc.remoting.dto.RpcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: djc
 * @Date: 2024-09-12-11:26
 * @Description: 自定义拦截器来处理服务器发来的消息
 */
@Slf4j
public class NettyRpcClientHandler extends ChannelInboundHandlerAdapter {
    private final UnprocessedRequests unprocessedRequests;
    private final NettyRpcClient nettyRpcClient;

    public NettyRpcClientHandler(){
        this.nettyRpcClient= SingletonFactory.getInstance(NettyRpcClient.class);
        this.unprocessedRequests=SingletonFactory.getInstance(UnprocessedRequests.class);
    }


    /**
     * 读取服务器发送的消息
     * @param channelHandlerContext
     * @param message
     */
    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext,Object message){
        try {
            log.info("client receive msg:[{}]",message);
            if (message instanceof RpcMessage){
                RpcMessage tmp=(RpcMessage) message;
                byte messageType = tmp.getMessageType();
                if(messageType== RpcConstants.REQUEST_TYPE){
                    RpcResponse<Object> response = (RpcResponse<Object>) tmp.getData();
                    unprocessedRequests.complete(response);
                } else if (messageType==RpcConstants.HEARTBEAT_RSPONSE_TYPE) {
                    log.info("heart[{}]",message);
                }
            }
        }finally {
            ReferenceCountUtil.release(message);
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        //todo
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("client catch exception: ",cause);
        cause.printStackTrace();
        ctx.close();
    }
}
