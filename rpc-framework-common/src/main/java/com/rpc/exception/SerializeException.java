package com.rpc.exception;

/**
 * @Author: djc
 * @Date: 2024-09-11-22:51
 * @Description:
 */
public class SerializeException extends RuntimeException {
    public SerializeException(String message) {
        super(message);
    }

    public SerializeException(String message, Throwable cause) {
        super(message, cause);
    }
}
