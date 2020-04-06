package com.peng.skeleton.routingservice.controller;

import com.peng.skeleton.common.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(path = "/routing")
public class RoutingController {
    //    private static final String REC_SERVICE = "http://rec.skeleton.svc.cluster.local/rec/get?a=%s";
    private static final String REC_SERVICE = "http://localhost:8089/rec/get?a=%s";

    @RequestMapping(path = "/get")
    public String getRecommendation() {
        Random u = new Random();
        return "[routing]" + HttpUtil.post(String.format(REC_SERVICE, String.valueOf(u.nextInt())));
    }
}
