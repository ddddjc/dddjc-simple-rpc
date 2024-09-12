package com.rpc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: djc
 * @Date: 2024-09-12-16:13
 * @Description:
 */
@AllArgsConstructor
@Getter
public enum LoadBalanceEnum {

    LOADBALANCE("loadBalance");

    private final String name;
}

