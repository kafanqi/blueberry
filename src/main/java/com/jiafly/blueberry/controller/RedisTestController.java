package com.jiafly.blueberry.controller;

import com.jiafly.blueberry.common.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyi
 */
@Slf4j
@RestController
@RequestMapping(path = "")
@Api(tags = "Redis测试模块")
public class RedisTestController {

    private final RedisUtils redisUtils;

    public RedisTestController(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @ApiOperation(value = "get", notes = "get")
    @GetMapping(path = "/get/{key}")
    public Object get(@PathVariable("key") String key) {
        log.info("get:{}", key);
        return redisUtils.get(key);
    }

    @ApiOperation(value = "set", notes = "set")
    @GetMapping(path = "/set/{key}/{value}")
    public String set(@PathVariable("key") String key, @PathVariable("value") String value) {
        redisUtils.set(key, value);
        log.info("set:key:{},value:{}", key, value);
        return "success";
    }
}
