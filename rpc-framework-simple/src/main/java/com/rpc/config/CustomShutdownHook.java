package com.rpc.config;

import com.rpc.registry.zk.util.CuratorUtils;
import com.rpc.remoting.transport.netty.server.NettyRpcServer;
import com.rpc.utils.concurrent.threadpool.ThreadPoolFactoryUtil;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @Author: djc
 * @Date: 2024-09-12-14:07
 * @Description: 当server关闭时，注销所有所服务节点
 */
@Slf4j
public class CustomShutdownHook {
    private static final CustomShutdownHook CUSTOM_SHUTDOWN_HOOK=new CustomShutdownHook();
    public static CustomShutdownHook getCustomShutdownHook(){
        return CUSTOM_SHUTDOWN_HOOK;
    }

    public void cleatAll(){
        log.info("addShutdownHook for clearALl");
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            try{
                InetSocketAddress inetSocketAddress=new InetSocketAddress(InetAddress.getLocalHost().getHostAddress(), NettyRpcServer.PORT);
                CuratorUtils.clearRegistry(CuratorUtils.getZKClient(),inetSocketAddress);
            } catch (UnknownHostException e) {

            }
            ThreadPoolFactoryUtil.shutDownAllThreadPool();
        }));
    }
}
