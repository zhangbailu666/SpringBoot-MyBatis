package com.qbian.common.exception;

import com.qbian.common.dto.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.SQLException;

/**
 * Created by Qbian on 2017/3/24.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 业务异常
     * @param response 响应
     * @param e 异常
     */
    @ExceptionHandler(value = ServiceException.class)
    public void handlerServiceException(HttpServletResponse response, Exception e) {
//        e.printStackTrace();
        Node node = ((ServiceException) e).getNode();
        try {
            response.getWriter().write(node.toJsonString());
        } catch (IOException e1) {
            LOG.debug("响应流已关闭。。。");
            e1.printStackTrace();
        }
    }

    @ExceptionHandler(value = SQLException.class)
    public void handlerSQLException(HttpServletResponse response, SQLException e) {
        e.printStackTrace();
        try {
            response.getWriter().write(new Node(-998).toJsonString());
        } catch (IOException e1) {
            LOG.debug("响应流已关闭。。。");
            e1.printStackTrace();
        }
    }

    @ExceptionHandler(value = ConnectException.class)
    public void handlerNetworkException(HttpServletResponse response,ConnectException e) {
        e.printStackTrace();
        try {
            response.getWriter().write(new Node(-997).toJsonString());
        } catch (IOException e1) {
            LOG.debug("响应流已关闭。。。");
            e1.printStackTrace();
        }
    }

}
