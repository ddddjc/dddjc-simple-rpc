package com.rpc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: djc
 * @Date: 2024-09-12-10:10
 * @Description:
 */
@AllArgsConstructor
@Getter
public enum RpcRequestTransportEnum {
    NETTY("netty");

    private final String name;
}
