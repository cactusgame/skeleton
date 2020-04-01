package com.peng.skeleton.recservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rec")
@SpringBootApplication
public class RecServiceApplication {

    @RequestMapping(path = "/get")
    public String getRecommendation() {
        return "[rec-service]This is rec result v2";
    }

    public static void main(String[] args) {
        SpringApplication.run(RecServiceApplication.class, args);
    }

}
