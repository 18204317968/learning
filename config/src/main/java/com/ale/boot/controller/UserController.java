package com.ale.boot.controller;

import com.ale.boot.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(value = "用户相关接口")
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @ApiOperation("新增用户")
    @PostMapping("/addUser")
    public User addUser(@RequestBody @Validated User user) {
        log.info("用户保存成功");
        return user;
    }

    @ApiOperation("获取用户")
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable int id) {
        User user = new User();
        user.setId(id);
        user.setCreateTime(new Date());
        user.setName("ale");
        user.setUserName("高乐高");
        user.setPassword("Ale@521.com");
        Assert.notNull(null, "用户不存在");
        return user;
    }
}
