package com.rpc.registry;

import com.rpc.extension.SPI;
import com.rpc.remoting.dto.RpcRequest;

import java.net.InetSocketAddress;

/**
 * @Author: djc
 * @Date: 2024-09-12-10:57
 * @Description:
 */
@SPI
public interface ServiceDiscovery {

    /**
     * 通关rocServiceName查找服务
     * @param request
     * @return
     */
    InetSocketAddress lookupService(RpcRequest request);
}
