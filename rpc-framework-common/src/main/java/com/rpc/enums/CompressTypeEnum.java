package com.rpc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: djc
 * @Date: 2024-09-12-11:57
 * @Description:
 */

@AllArgsConstructor
@Getter
public enum CompressTypeEnum {
    GZIP((byte) 0x01,"gzip");
    private final byte code;
    private final String NAME;

    public static String getName(byte code){
        for (CompressTypeEnum c:
             CompressTypeEnum.values()) {
            if (c.getCode()==code){
                return c.NAME;
            }
        }
        return null;
    }
}
