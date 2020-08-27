package com.jiafly.blueberry.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 认证
 *
 * @author liuyi
 */
@RestController
@RequestMapping(path = "/auth")
@Api(tags = "用户认证模块")
public class AuthController {

    /**
     * 微信登录
     */
    public void wxLogin() {

    }

    /**
     * 邮箱登录 目前最主要方式 邮箱为必填项目
     */
    public void mailLogin() {

    }

    /**
     * 手机号登录
     */
    public void phoneLogin() {

    }

    /**
     * 联合登录
     */
    public void unionLogin() {

    }
}
