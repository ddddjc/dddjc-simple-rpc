package com.rpc.registry;

import com.rpc.extension.SPI;

import java.net.InetSocketAddress;

/**
 * @Author: djc
 * @Date: 2024-09-12-10:57
 * @Description:
 */
@SPI
public interface ServiceRegistry {
    /**
     * 注册服务
     * @param rpcServiceName
     * @param inetSocketAddress
     */
    void registerService(String rpcServiceName, InetSocketAddress inetSocketAddress);
}
