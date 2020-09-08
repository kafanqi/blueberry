package com.jiafly.blueberry.common.config;

import com.jiafly.blueberry.common.exception.ResultBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 *
 * @author liuyi
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static final int SYSTEM_ERROR = 500;

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultBody exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        logger.error("ExceptionHandler ===>" + e.getMessage());
        response.setStatus(SYSTEM_ERROR);
        return ResultBody.error();
    }

//    @ResponseBody
//    @ExceptionHandler(value = ClientException.class)
//    public ResultBody clientExceptionHandler(HttpServletRequest request, HttpServletResponse response, ClientException e) {
//        logger.error("ClientException ===>" + e.getMessage());
//        return ResultBody.error(e.getCode(), e.getMessage());
//    }

}
