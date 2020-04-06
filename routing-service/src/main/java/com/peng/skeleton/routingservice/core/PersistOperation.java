package com.peng.skeleton.routingservice.core;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PersistOperation {
    /**
     * return the CRUD type for each operation
     *
     * @return
     */
    PersistOperationType type();
}
