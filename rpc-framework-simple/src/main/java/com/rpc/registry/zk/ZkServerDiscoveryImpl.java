package com.rpc.registry.zk;

import com.rpc.enums.LoadBalanceEnum;
import com.rpc.enums.RpcErrorMessageEnum;
import com.rpc.exception.RpcException;
import com.rpc.extension.ExtensionLoader;
import com.rpc.loadbalance.LoadBalance;
import com.rpc.registry.ServiceDiscovery;
import com.rpc.registry.zk.util.CuratorUtils;
import com.rpc.remoting.dto.RpcRequest;
import com.rpc.utils.concurrent.threadpool.utils.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @Author: djc
 * @Date: 2024-09-12-15:44
 * @Description:
 */
@Slf4j
public class ZkServerDiscoveryImpl implements ServiceDiscovery {
    private final LoadBalance loadBalance;

    public ZkServerDiscoveryImpl() {
        this.loadBalance= ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension(LoadBalanceEnum.LOADBALANCE.getName());
    }
    @Override
    public InetSocketAddress lookupService(RpcRequest request) {
        String rpcServiceName = request.getRpcServiceName();
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        List<String> serviceUrlList = CuratorUtils.getChildrenNodes(zkClient, rpcServiceName);
        if(CollectionUtil.isEmpty(serviceUrlList)){
            throw new RpcException(RpcErrorMessageEnum.SERVICE_CAN_NOT_BE_FOUND,rpcServiceName);
        }
        String targetServiceUrl = loadBalance.selectServiceAddress(serviceUrlList, request);
        log.info("Successfully found the service address:[{}]", targetServiceUrl);
        String[] socketAddressArray = targetServiceUrl.split(":");
        String host = socketAddressArray[0];
        int port = Integer.parseInt(socketAddressArray[1]);
        return new InetSocketAddress(host, port);
    }
}
