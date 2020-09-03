package com.jiafly.blueberry.common.exception;

/**
 * @author liuyi
 */
public enum ExceptionEnum implements ExceptionInterface {
    /**
     * 系统异常
     */
    SUCCESS(200, "success"),
    NOT_AUTHORIZED(401, "not authorized"),
    NOT_FOUND(404, "resource not found"),
    ERROR(500, "error"),
    SERVER_BUSY(503, "server is busy");

    private final Integer code;
    private final String message;

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
