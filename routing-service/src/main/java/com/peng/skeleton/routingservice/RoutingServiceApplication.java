package com.peng.skeleton.routingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/routing")
@SpringBootApplication
public class RoutingServiceApplication {

	@GetMapping(path = "/get")
	public String getRecommendation() {
		return "hello world peng";
	}


	public static void main(String[] args) {
		SpringApplication.run(RoutingServiceApplication.class, args);
	}

}
