package com.rpc.loadbalance;

import com.rpc.extension.SPI;
import com.rpc.remoting.dto.RpcRequest;
import com.rpc.utils.concurrent.threadpool.utils.CollectionUtil;

import java.util.List;

/**
 * @Author: djc
 * @Date: 2024-09-12-15:47
 * @Description:
 */
@SPI
public interface LoadBalance {
    /**
     * 选择一个进行访问
     * @param serviceUrlList
     * @param rpcRequest
     * @return
     */
    default String selectServiceAddress(List<String> serviceUrlList, RpcRequest rpcRequest){
        if(CollectionUtil.isEmpty(serviceUrlList)){
            return null;
        }
        if(serviceUrlList.size()==1){
            return serviceUrlList.get(0);
        }
        return doSelect(serviceUrlList,rpcRequest);
    }

     String doSelect(List<String> serviceUrlList, RpcRequest rpcRequest);

}
