package com.peng.sb.demo.config;

import com.peng.sb.demo.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {

    @Bean
    public Car initCar() {
        Car a = new Car();
        a.setName("audi");
        return a;
    }

}
