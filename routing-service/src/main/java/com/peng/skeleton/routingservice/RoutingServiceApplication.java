package com.peng.skeleton.routingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication(scanBasePackages = {
        "com.peng.skeleton.common.service",
        "com.peng.skeleton.routingservice.controller",
        "com.peng.skeleton.routingservice.service",
        "com.peng.skeleton.routingservice.config",
        "com.peng.skeleton.common.dao"})
public class RoutingServiceApplication {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(RoutingServiceApplication.class, args);
    }

}
