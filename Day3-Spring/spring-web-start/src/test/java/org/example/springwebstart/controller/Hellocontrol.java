package org.example.springwebstart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//请求处理类
@RestController
public class Hellocontrol {
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("Hello world");
        return "Hello world";
    }
}
