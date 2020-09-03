package com.jiafly.blueberry.common.exception;

/**
 * 客户端异常
 *
 * @author liuyi
 */
public class ClientException extends RuntimeException {

    private Integer code;
    private String message;

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

    /**
     * 异常构造
     *
     * @param message 异常信息
     */
    public ClientException(String message) {
        super(message);
    }

    /**
     * 异常枚举构造
     *
     * @param exceptionInterface 枚举
     */
    public ClientException(ExceptionInterface exceptionInterface) {
        super(exceptionInterface.getMessage());
        this.code = exceptionInterface.getCode();
    }

    /**
     * 异常构造
     *
     * @param message string format message
     * @param args    参数
     */
    public ClientException(String message, Object... args) {
        super(String.format(message, args));
    }

    /**
     * 用表示异常原因的对象构造新实例。
     *
     * @param cause 异常原因。
     */
    public ClientException(Throwable cause) {
        super(cause.getMessage(), cause);
    }

    /**
     * 用异常消息和表示异常原因的对象构造新实例。
     *
     * @param message 异常信息。
     * @param cause   异常原因。
     */
    public ClientException(String message, Throwable cause) {
        super(message, cause);
    }


    /**
     * 用给定的异常信息构造新实例。
     *
     * @param code    code
     * @param message message
     */
    public ClientException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
