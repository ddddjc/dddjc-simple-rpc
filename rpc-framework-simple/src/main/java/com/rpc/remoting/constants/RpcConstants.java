package com.rpc.remoting.constants;

/**
 * @Author: djc
 * @Date: 2024-09-12-11:22
 * @Description:
 */
public class RpcConstants {

    public static final int MAX_FRAME_LENGTH = 8 * 1024 * 1024;

    public static final byte REQUEST_TYPE = 1;
    public static final byte RESPONSE_TYPE = 2;
    public static final byte HEARTBEAT_REQUEST_TYPE = 3;
    public static final byte HEARTBEAT_RSPONSE_TYPE = 4;
    public static final String PONG = "pong";
    public static final String PING ="PING";

}
