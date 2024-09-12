package com.rpc.registry.zk;

import com.rpc.registry.ServiceDiscovery;
import com.rpc.remoting.dto.RpcRequest;

import java.net.InetSocketAddress;

/**
 * @Author: djc
 * @Date: 2024-09-12-15:44
 * @Description:
 */
public class ZkServerDiscoveryImpl implements ServiceDiscovery {
    @Override
    public InetSocketAddress lookupService(RpcRequest request) {
        return null;
    }
}
