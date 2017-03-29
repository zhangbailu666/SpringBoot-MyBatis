package com.qbian.common.util;

/**
 * Created by Qbian on 2017/3/24.
 */
public class Const {

    private Const() {}

    public static final String ERROR_CODE_PREFIX = "error_code_";   // 属性文件错误码前缀
    public static final String REQUEST_PARAM_NAME = "params";       // 鉴权接口的请求参数名

    // 数据库删除状态
    public static final int DELETE = 1;     // 已删除
    public static final int UN_DELETE = 2;  // 未删除

}
