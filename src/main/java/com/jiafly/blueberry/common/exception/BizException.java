package com.jiafly.blueberry.common.exception;

/**
 * 业务异常
 *
 * @author liuyi
 */
public class BizException extends RuntimeException {

    private Integer code;
    private String message;

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BizException(ExceptionInterface exceptionInterface) {
        super(exceptionInterface.getMessage());
        this.code = exceptionInterface.getCode();
        this.message = exceptionInterface.getMessage();
    }

    public BizException(ExceptionInterface exceptionInterface, Throwable cause) {
        super(exceptionInterface.getMessage(), cause);
        this.code = exceptionInterface.getCode();
        this.message = exceptionInterface.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
