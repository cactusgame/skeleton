package com.peng.skeleton.routingservice.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CreateOperation implements IPersistOperation {
    private final String sql;

    public CreateOperation(String tableName, Method method, Object[] objects) {
        // get primary key
        // todo: assume, there is only 1 parameter
        Object domainObject = objects[0];
        Field[] fieldsForDomainObject = domainObject.getClass().getDeclaredFields();

        // todo: to check the empty param
        String pkName = "";
        String pkValue = "";
        for (Field c : fieldsForDomainObject) {
            if (c.getAnnotation(PersistPrimaryKey.class) != null) {
                try {
                    c.setAccessible(true);
                    pkName = c.getName();
                    pkValue =c.get(domainObject).toString();
                    System.out.println(String.format("the primary key is '%s' and it's value = %s", pkName, pkValue));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

        // encode object, maybe json or bytes
        String objectEncodeValue = "this is a mock value";
        this.sql = String.format("INSERT INTO %s (%s, value) VALUES (%s, %s);", tableName, pkName, pkValue, objectEncodeValue);
    }

    @Override
    public Object execute() {
        System.out.println(String.format("[MySQL CREATE OPERATION] sql = %s", sql));
        return null;
    }


}
