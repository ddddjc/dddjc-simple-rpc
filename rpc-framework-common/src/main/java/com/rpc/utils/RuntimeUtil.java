package com.rpc.utils;

/**
 * @Author: djc
 * @Date: 2024-09-11-23:09
 * @Description:
 */
public class RuntimeUtil {
    /**
     * 获取CPU核心数
     *
     * @return
     */
    public static int cpus() {
        return Runtime.getRuntime().availableProcessors();
    }
}
