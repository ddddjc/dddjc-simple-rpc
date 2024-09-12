package com.rpc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author: djc
 * @Date: 2024-09-12-10:07
 * @Description:
 */
@AllArgsConstructor
@Getter
@ToString
public enum RpcResponseCodeEnum {
    SUCCESS(200,"The remote call is Successful"),
    FAIL(500,"The remote call is fail");

    private final int code;
    private final String message;
}
