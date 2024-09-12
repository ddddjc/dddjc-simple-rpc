package com.rpc.remoting.transport;

import com.rpc.extension.SPI;
import com.rpc.remoting.dto.RpcRequest;

/**
 * @Author: djc
 * @Date: 2024-09-12-10:35
 * @Description:
 */
@SPI
public interface RpcRequestTransport {
    /**
     * 向服务器发送请求并获取结果
     * @param rpcRequest
     * @return
     */
    Object sendRpcRequest(RpcRequest rpcRequest);
}
