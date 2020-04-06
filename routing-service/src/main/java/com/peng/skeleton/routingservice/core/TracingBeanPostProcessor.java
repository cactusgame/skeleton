package com.peng.skeleton.routingservice.core;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class TracingBeanPostProcessor implements BeanPostProcessor {

    // simply return the instantiated bean as-is
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("Bean '" + beanName + "' postProcessBeforeInitialization : " + bean.toString());
        return bean; // we could potentially return any object reference here...
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("Bean '" + beanName + "' postProcessAfterInitialization : " + bean.toString());
        return bean;
    }
}
