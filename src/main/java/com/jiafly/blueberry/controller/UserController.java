package com.jiafly.blueberry.controller;


import com.jiafly.blueberry.domain.dto.UserCreateCommand;
import com.jiafly.blueberry.domain.dto.UserResult;
import com.jiafly.blueberry.domain.dto.UserSearchCommand;
import com.jiafly.blueberry.domain.dto.UserUpdateCommand;
import com.jiafly.blueberry.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyi
 */
@Slf4j
@RestController
@RequestMapping(path = "/user")
@Api(tags = "用户模块")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @PostMapping(path = "")
    public UserResult create(@RequestBody UserCreateCommand createCommand) {
        return new UserResult();
    }

    @ApiOperation(value = "查询用户", notes = "查询用户")
    @GetMapping(path = "/{username}")
    public UserResult getByUsername(@PathVariable("username") String username) {
        return new UserResult();
    }

    @ApiOperation(value = "修改用户", notes = "修改用户")
    @PutMapping(path = "/{username}")
    public UserResult update(@PathVariable("username") String username, @RequestBody UserUpdateCommand updateCommand) {
        return new UserResult();
    }

    @ApiOperation(value = "冻结用户", notes = "冻结用户")
    @DeleteMapping(path = "/{username}")
    public boolean free(@PathVariable("username") String username) {
        return true;
    }

    @ApiOperation(value = "查询用户", notes = "查询用户")
    @GetMapping(path = "/search")
    public List<UserResult> search(@RequestBody UserSearchCommand searchCommand) {
        return new ArrayList<>();
    }





}
