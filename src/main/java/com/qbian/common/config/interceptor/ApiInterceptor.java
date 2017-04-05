package com.qbian.common.config.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qbian.common.util.Const;
import com.qbian.common.dto.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Qbian on 2017/3/24.
 */
@Service
public class ApiInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ApiInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 开启跨域访问
        response.setHeader("Access-Control-Allow-Origin", "*");
        String uri = request.getRequestURI();
        String method = request.getMethod();
        LOG.info("=================Received Request==================");
        LOG.info("Method：" + method + " ===》 Interface：" + uri);

        // 异常返回（系统错误）
        if("/error".equals(uri)) {
            int httpStatus = response.getStatus();
            // 服务器错误
            if(500 <= httpStatus && 600 > httpStatus) {
                response.getWriter().write(new Node(-999).toJsonString());
                return false;
            }
            // 客户端请求错误
            if(400 <= httpStatus && 500 > httpStatus) {
                response.getWriter().write(new Node(-996).toJsonString());
                return false;
            }
        }
        // GET 请求不鉴权
        if("GET".equals(method)) {
            return true;
        }
        // 需要鉴权 token 的接口协议
        if("POST".equals(method) || "PUT".equals(method) || "DELETE".equals(method)) {
            InputStream inputStream = request.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String s = "";
            StringBuffer sb = new StringBuffer();
            while(null != (s = br.readLine())) {
                sb.append(s);
            }
            String requestData = sb.toString();
            LOG.info("Request param：" + requestData);
            if(StringUtils.isEmpty(requestData)) {
                response.getWriter().write(new Node(-902).toJsonString());
                return false;
            }
            JSONObject jsonObject = null;
            try {
                jsonObject = JSON.parseObject(requestData);
            } catch (Exception e) {
                response.getWriter().write(new Node(-903).toJsonString());
                return false;
            }
            String token = jsonObject.getString("token");
            if(StringUtils.isEmpty(token)) {
                response.getWriter().write(new Node(-904).toJsonString());
                return false;
            }
            // TODO 校验 token
            if(!"123456".equals(token)) {
                response.getWriter().write(new Node(-905).toJsonString());
                return false;
            }
            request.setAttribute(Const.REQUEST_PARAM_NAME, jsonObject);
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);

    }
}
