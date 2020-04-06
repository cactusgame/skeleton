package com.peng.skeleton.routingservice.config;


import com.peng.skeleton.routingservice.core.PersistFactory;
import com.peng.skeleton.routingservice.dao.IUserDao;
import com.peng.skeleton.routingservice.core.TracingBeanFactoryPostProcessor;
import com.peng.skeleton.routingservice.core.TracingBeanPostProcessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DaoConfig {

    @Bean
    public TracingBeanFactoryPostProcessor tracingBeanFactoryPostProcessor() {
        return new TracingBeanFactoryPostProcessor();
    }

    @Bean
    public TracingBeanPostProcessor tracingBeanPostProcessor() {
        return new TracingBeanPostProcessor();
    }

    @Bean
    public IUserDao userDao() {
        return PersistFactory.getDAO(IUserDao.class);
    }
}
