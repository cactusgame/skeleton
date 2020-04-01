package com.peng.skeleton.routingservice;

import com.peng.skeleton.common.HttpUtil;
import com.peng.skeleton.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thread.usecase.load.LoadBusiness;

import java.util.Random;
import java.util.concurrent.*;

@RestController
@RequestMapping(path = "/routing")
@SpringBootApplication(scanBasePackages = {"com.peng.skeleton.common.service", "com.peng.skeleton.routingservice.controller"})
public class RoutingServiceApplication {

    @Autowired
    private UserService userService;

    //    private static final String REC_SERVICE = "http://rec.skeleton.svc.cluster.local/rec/get?a=%s";
    private static final String REC_SERVICE = "http://localhost:8089/rec/get?a=%s";

    @RequestMapping(path = "/get")
    public String getRecommendation() {
        Random u = new Random();
        return "[routing]" + HttpUtil.post(String.format(REC_SERVICE, String.valueOf(u.nextInt())));
    }

    @RequestMapping(path = "/test")
    public String getTest() {
        return "[routing] This is a test message:" + userService.getName();
    }

    public static void main(String[] args) {
        SpringApplication.run(RoutingServiceApplication.class, args);
    }

}
