package com.rpc.utils.concurrent.threadpool.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @Author: djc
 * @Date: 2024-09-11-23:16
 * @Description:
 */
@Slf4j
public final class PropertiesFileUtil {
    private PropertiesFileUtil(){}

    public static Properties readPropertiesFile(String fileName){
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
        String rpcConfigPath="";
        if(url!=null){
            rpcConfigPath=url.getPath()+fileName;
        }
        Properties properties=null;
        try(InputStreamReader in=new InputStreamReader(
                new FileInputStream(rpcConfigPath), StandardCharsets.UTF_8)){
            properties=new Properties();
            properties.load(in);
        }catch (IOException e){
            log.error("occur exception when read properties file [{}]", fileName);
        }
        return properties;
    }
}
