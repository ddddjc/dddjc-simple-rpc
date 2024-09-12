package com.rpc.registry.zk;

import com.rpc.enums.LoadBalanceEnum;
import com.rpc.extension.ExtensionLoader;
import com.rpc.loadbalance.LoadBalance;
import com.rpc.registry.ServiceRegistry;
import com.rpc.registry.zk.util.CuratorUtils;
import org.apache.curator.framework.CuratorFramework;

import java.net.InetSocketAddress;

/**
 * @Author: djc
 * @Date: 2024-09-12-15:44
 * @Description:
 */
public class ZkServiceRegistryImpl implements ServiceRegistry {


    @Override
    public void registerService(String rpcServiceName, InetSocketAddress inetSocketAddress) {
        String servicePath = CuratorUtils.ZK_REGISTER_ROOT_PATH + "/" + rpcServiceName + inetSocketAddress.toString();
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        CuratorUtils.createPersistentNode(zkClient,servicePath);
    }
}
