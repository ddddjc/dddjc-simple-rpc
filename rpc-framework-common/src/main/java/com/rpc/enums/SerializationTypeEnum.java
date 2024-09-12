package com.rpc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: djc
 * @Date: 2024-09-12-11:54
 * @Description:
 */

@AllArgsConstructor
@Getter
public enum SerializationTypeEnum {
    KRYO((byte) 0x01,"kryo");

    private final byte code;
    private final String name;
}
