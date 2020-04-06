package com.peng.skeleton.routingservice.pojo;

import com.peng.skeleton.routingservice.core.PersistPrimaryKey;

public class User {
    @PersistPrimaryKey
    private int id;
    private String name;

    public User(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
