package com.peng.skeleton.routingservice.dao;

import com.peng.skeleton.routingservice.core.Persist;

@Persist(table = "temp")
public class TmpDao {

    public void test(){
        System.out.println("hello");
    }
    public static void main(String[] args){


        TmpDao t = new TmpDao();
        Persist p = t.getClass().getAnnotation(Persist.class);

        System.out.println(p.table());
    }
}
