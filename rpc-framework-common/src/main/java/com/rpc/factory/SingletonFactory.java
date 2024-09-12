package com.rpc.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: djc
 * @Date: 2024-09-12-11:35
 * @Description: 获取单例对象的工厂类
 */
public final class SingletonFactory {
    private static final Map<String, Object> OBJECT_MAP=new ConcurrentHashMap<>();
    private static final Object lock=new Object();
    private SingletonFactory(){

    }

    public static <T> T getInstance(Class<T> c){
        if (c==null){
            throw new IllegalArgumentException();
        }
        String key=c.toString();
        if(OBJECT_MAP.containsKey(key)){
            return c.cast(OBJECT_MAP.get(key));
        } else{
            synchronized (lock){
                if(!OBJECT_MAP.containsKey(key)){
                    try{
                        T instance = c.getDeclaredConstructor().newInstance();
                        OBJECT_MAP.put(key,instance);
                        return instance;
                    } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                             NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    return c.cast(OBJECT_MAP.get(key));
                }
            }
        }
    }
}
