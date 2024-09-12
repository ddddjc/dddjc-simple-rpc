package com.rpc.serialize;

import com.rpc.extension.SPI;

/**
 * @Author: djc
 * @Date: 2024-09-12-9:54
 * @Description:
 */
@SPI
public interface Serializer {

    /**
     * 序列化
     * @param o
     * @return
     */
    byte[] serialize(Object o);

    /**
     * 反序列化
     * @param bytes
     * @param clazz
     * @return
     * @param <T>
     */
    <T> T deserialization(byte[] bytes,Class<T> clazz);

}
