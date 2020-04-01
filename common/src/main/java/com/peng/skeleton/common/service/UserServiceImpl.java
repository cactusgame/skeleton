package com.peng.skeleton.common.service;

import com.peng.skeleton.common.dao.UserDao;
import com.peng.skeleton.common.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    public UserServiceImpl(){
        System.out.println("this is user service");
    }

    @Override
    public void createUser(User user){
        UserDao dao = new UserDao();
        dao.createUser(user);
    }

    @Override
    public String getName() {
        return "Baby";
    }
}
