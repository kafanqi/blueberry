package com.jiafly.blueberry.service;

/**
 * @author liuyi
 */
public interface MailService {

    /**
     * 发送邮箱验证码
     *
     * @param to to
     * @return 是否成功
     */
    boolean sendVerifyCode(String to);
}
