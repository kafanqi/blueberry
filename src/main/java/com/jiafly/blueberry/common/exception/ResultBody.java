package com.jiafly.blueberry.common.exception;

/**
 * 通用返回
 *
 * @author liuyi
 */
public class ResultBody {
    /**
     * 响应代码
     */
    private Integer code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应数据
     */
    private Object data;

    public ResultBody() {
    }

    public ResultBody(ExceptionInterface exceptionInterface) {
        this.code = exceptionInterface.getCode();
        this.message = exceptionInterface.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultBody success(Object data) {
        ResultBody result = new ResultBody();
        result.setCode(ExceptionEnum.SUCCESS.getCode());
        result.setMessage(ExceptionEnum.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static ResultBody error() {
        ResultBody result = new ResultBody();
        result.setCode(ExceptionEnum.ERROR.getCode());
        result.setMessage(ExceptionEnum.ERROR.getMessage());
        return result;
    }

    public static ResultBody error(ExceptionInterface exceptionInterface) {
        ResultBody result = new ResultBody();
        result.setCode(exceptionInterface.getCode());
        result.setMessage(exceptionInterface.getMessage());
        return result;
    }

    public static ResultBody error(Integer code, String message) {
        ResultBody result = new ResultBody();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

}
