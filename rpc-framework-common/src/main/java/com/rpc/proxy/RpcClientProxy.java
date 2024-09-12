package com.rpc.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: djc
 * @Date: 2024-09-12-15:19
 * @Description:
 */
@Slf4j
public class RpcClientProxy implements InvocationHandler {
    // TODO: 2024/9/12  
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
