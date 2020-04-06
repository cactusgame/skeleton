package com.peng.skeleton.routingservice.dao;


import com.peng.skeleton.routingservice.pojo.User;
import com.peng.skeleton.routingservice.core.*;

import java.util.List;

@Persist(table = "user")
public interface IUserDao {

    @PersistOperation(type = PersistOperationType.CREATE)
    public String create(User user);

    @PersistOperation(type = PersistOperationType.DELETE)
    public String delete(int id);

    @PersistOperation(type = PersistOperationType.UPDATE)
    public String update(User user);

    @PersistOperation(type = PersistOperationType.READ)
    public String getUsers(List<Integer> ids);

    @PersistOperation(type = PersistOperationType.READ)
    public String getUsers();
}
