package com.peng.skeleton.routingservice.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Persist {
    /**
     * get the table name for storage
     * @return
     */
    String table();
}
