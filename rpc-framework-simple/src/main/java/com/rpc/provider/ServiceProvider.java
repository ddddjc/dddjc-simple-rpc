package com.rpc.provider;

import com.rpc.config.RpcServiceConfig;

/**
 * @Author: djc
 * @Date: 2024-09-12-12:35
 * @Description: 存储和提供服务对象
 */
public interface ServiceProvider {
    void addService(RpcServiceConfig rpcServiceConfig);

    Object getService(String rpcServiceName);

    void publishService(RpcServiceConfig rpcServiceConfig);
}
