package com.rpc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: djc
 * @Date: 2024-09-12-11:32
 * @Description:
 */

@AllArgsConstructor
@Getter
public enum ServiceDiscoverEnum {
    ZK("ZK");
    private final String name;
}
