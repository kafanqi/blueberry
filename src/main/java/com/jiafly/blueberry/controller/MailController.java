package com.jiafly.blueberry.controller;

import com.jiafly.blueberry.service.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 邮件服务
 *
 * @author liuyi
 */
@RestController
@RequestMapping(path = "/mail")
@Api(tags = "邮箱模块")
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    /**
     * 发送验证码
     */
    @ApiOperation(value = "邮箱发送验证码", notes = "邮箱发送验证码")
    @PostMapping(path = "/verify/code")
    public boolean sendVerifyCode(@RequestParam("email") String email) {
        return mailService.sendVerifyCode(email);
    }

    /**
     * 发送验证链接
     */
    @ApiOperation(value = "邮箱发送验证链接", notes = "邮箱发送验证链接")
    @PostMapping(path = "/verify/url")
    public void sendVerifyUrl() {

    }
}
