package com.example.mall.controller;

import com.example.mall.pojo.User;
import com.example.mall.service.UserService;
import com.example.mall.util.Page4Navigate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/users")
    public Page4Navigate<User> list(@RequestParam(value = "start",defaultValue = "0")int start, @RequestParam(value = "size",defaultValue = "5")int size) throws Exception{
        start =start<0?0:start;
        Page4Navigate<User> page=userService.list(start,size,5);
        return page;

    }

}
