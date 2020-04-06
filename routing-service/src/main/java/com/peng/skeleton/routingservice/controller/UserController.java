package com.peng.skeleton.routingservice.controller;

import com.peng.skeleton.routingservice.pojo.User;
import com.peng.skeleton.routingservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/get")
    public String getUsers() {
        return "[user]" + userService.getUsers();
    }

    @RequestMapping(path = "/create")
    public void createUser() {
        userService.createUser(new User("peng"));
    }
}
