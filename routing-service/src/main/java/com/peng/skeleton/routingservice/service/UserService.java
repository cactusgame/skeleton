package com.peng.skeleton.routingservice.service;

import com.peng.skeleton.routingservice.pojo.User;

public interface UserService {
    void createUser(User user);

    String getUsers();
}
