package com.jiafly.blueberry.service.impl;

import com.jiafly.blueberry.common.exception.BizException;
import com.jiafly.blueberry.common.exception.ExceptionEnum;
import com.jiafly.blueberry.common.utils.DateUtils;
import com.jiafly.blueberry.common.utils.MailUtils;
import com.jiafly.blueberry.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 邮件服务层
 *
 * @author liuyi
 */
@Service
public class MailServiceImpl implements MailService {

    private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    private final MailUtils mailUtils;

    public MailServiceImpl(MailUtils mailUtils) {
        this.mailUtils = mailUtils;
    }

    @Override
    public boolean sendVerifyCode(String to) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "liuyi1181");
        map.put("email", to);
        map.put("verifyCode", "957587");
        map.put("currentTime", DateUtils.getCurrentDatePattern(DateUtils.DATE_PATTERN_LONG));
        try {
            mailUtils.sendTemplateMail("system@jiafly.com", to, "JIAFly验证码", "mail/mailVerifyCode", map);
        } catch (Exception e) {
            logger.error("发送邮件异常，异常信息：{}，收件人：{}", e.getMessage(), to);
            throw new BizException(ExceptionEnum.SEND_MAIL_ERROR);
        }
        return true;
    }

}
