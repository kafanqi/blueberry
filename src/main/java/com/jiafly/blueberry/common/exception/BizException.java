package com.jiafly.blueberry.common.exception;

/**
 * 业务异常
 *
 * @author liuyi
 */
public class BizException extends RuntimeException {

    private Integer code;
    private String message;

    public BizException() {
        super();
    }

    public BizException(ExceptionInterface errorInfoInterface) {
        super(errorInfoInterface.getMessage());
        this.code = errorInfoInterface.getCode();
    }

    public BizException(ExceptionInterface errorInfoInterface, Throwable cause) {
        super(errorInfoInterface.getMessage(), cause);
        this.code = errorInfoInterface.getCode();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
