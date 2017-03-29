package com.qbian.common.util;

import java.util.UUID;

/**
 * Created by Qbian on 2017/3/27.
 */
public class StringUtil {
    private StringUtil() {}

    public static String getUUIDString() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
