package com.peng.skeleton.routingservice;

import com.peng.skeleton.common.HttpUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/routing")
@SpringBootApplication
public class RoutingServiceApplication {

    private static final String REC_SERVICE = "http://rec.default.svc.cluster.local/rec/get";

    @GetMapping(path = "/get")
    public String getRecommendation() {
        System.out.println("call rec service");
        System.out.println(HttpUtil.post("http://www.baidu.com"));
        return "ready to call rec service a";
    }


    public static void main(String[] args) {
        SpringApplication.run(RoutingServiceApplication.class, args);
    }

}
