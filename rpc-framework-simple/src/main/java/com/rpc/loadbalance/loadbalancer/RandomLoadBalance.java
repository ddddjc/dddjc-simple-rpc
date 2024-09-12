package com.rpc.loadbalance.loadbalancer;

import com.rpc.loadbalance.LoadBalance;
import com.rpc.remoting.dto.RpcRequest;

import java.util.List;
import java.util.Random;

/**
 * @Author: djc
 * @Date: 2024-09-12-15:57
 * @Description:
 */
public class RandomLoadBalance implements LoadBalance {

    @Override
    public String doSelect(List<String> serviceUrlList, RpcRequest rpcRequest) {
        Random random=new Random();
        return serviceUrlList.get(random.nextInt(serviceUrlList.size()));
    }
}
