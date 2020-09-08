package com.jiafly.blueberry.common.exception;

/**
 * @author liuyi
 */
public enum ExceptionEnum implements ExceptionInterface {
    /**
     * 系统异常
     */
    SEND_MAIL_ERROR(9001, "发送邮件失败"),
    SUCCESS(200, "成功"),
    NOT_AUTHORIZED(401, "没有权限"),
    NOT_FOUND(404, "没有资源"),
    ERROR(500, "系统异常"),
    SERVER_BUSY(503, "服务繁忙");

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
