package com.peng.sb.demo;

import com.peng.sb.demo.bean.Car;
import com.peng.sb.demo.utils.ClassLocationUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    public Car car;

    @Test
    void contextLoads() {
    }

    @Test
    public void testClassLocation() {
        System.out.println(">>> class location: " + ClassLocationUtils.where(SpringBootTest.class));
    }

    @Test
    public void testBean(){
        System.out.println(car.getName());

    }
}
