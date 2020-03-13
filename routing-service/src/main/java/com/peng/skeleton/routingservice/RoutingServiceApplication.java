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

//    private static final String REC_SERVICE = "http://rec.default.svc.cluster.local/rec/get";
    private static final String REC_SERVICE = "http://localhost:8089/rec/get";

    @RequestMapping(path = "/get")
    public String getRecommendation() {
        return "[routing]" + HttpUtil.post(REC_SERVICE);
    }


    public static void main(String[] args) {
        SpringApplication.run(RoutingServiceApplication.class, args);
    }

}
