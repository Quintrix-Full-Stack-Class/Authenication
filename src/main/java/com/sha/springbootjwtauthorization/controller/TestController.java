package com.sha.springbootjwtauthorization.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class TestController {
    public String helloWorld(){
        return "hello world";
    }
}
