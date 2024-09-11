package com.rpc.utils.concurrent.threadpool.utils;

import java.util.Collection;

/**
 * @Author: djc
 * @Date: 2024-09-11-23:14
 * @Description:
 */
public class CollectionUtil {
    public static boolean isEmpty(Collection<?> c) {
        return c == null || c.isEmpty();
    }
}
