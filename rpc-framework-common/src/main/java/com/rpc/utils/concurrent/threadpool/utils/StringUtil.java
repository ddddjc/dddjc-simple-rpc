package com.rpc.utils.concurrent.threadpool.utils;

/**
 * @Author: djc
 * @Date: 2024-09-11-23:11
 * @Description:
 */
public class StringUtil {
    public static boolean isBlank(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
