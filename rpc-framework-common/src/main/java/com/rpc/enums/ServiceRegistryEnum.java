package com.rpc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: djc
 * @Date: 2024-09-12-12:48
 * @Description:
 */
@AllArgsConstructor
@Getter
public enum ServiceRegistryEnum {
    ZK("zk");

    private final String name;
}
