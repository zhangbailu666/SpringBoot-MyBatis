package com.qbian.common.util;

import com.alibaba.fastjson.JSONObject;
import com.qbian.common.exception.ServiceException;
import com.qbian.common.dto.Node;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

/**
 * Created by Qbian on 2017/3/24.
 */
public class CheckUtil {
    private CheckUtil() {}

    /**
     * 校验请求参数是否为空
     * @param request HttpServletRequest
     * @param keys 待校验的参数
     * @return 请求参数转 JSONObject
     */
    public static JSONObject checkParamsEmpty(HttpServletRequest request, String ... keys) {
        StringBuilder sb  = new StringBuilder();
        JSONObject jsonParams = (JSONObject) request.getAttribute(Const.REQUEST_PARAM_NAME);
        for (String key : keys) {
            String value = jsonParams.getString(key);
            if(StringUtils.isEmpty(value)) {
                sb.append(",");
                sb.append(key);
            }
        }
        if(0 < sb.length()) {
            Node node = new Node(-906);
            String msg = node.getMsg();
            sb.delete(0, 1);
            node.setMsg(MessageFormat.format(msg, sb.toString()));
            throw new ServiceException(node);
        }
        return jsonParams;
    }

}
