package com.peng.skeleton.routingservice.service;

import com.peng.skeleton.routingservice.pojo.User;
import com.peng.skeleton.routingservice.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public IUserDao userDao;

    public UserServiceImpl() {
        System.out.println("this is user service");
    }

    @Override
    public void createUser(User user){
        userDao.create(user);
    }

    @Override
    public String getUsers() {
        return userDao.getUsers();
    }
}
