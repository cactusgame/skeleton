package com.peng.sb.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/example")
public class ExampleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getExamples() {
        return "OK";
    }
}
