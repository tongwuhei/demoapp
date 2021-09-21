package com.ch.demoapp.aop.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chj
 * @date 2021/6/8 19:49
 */
@RestController
public class MyApi {

    @GetMapping("/aspect")
    public String get(String user, String password) {
        System.out.println("成功执行 " + user + " " + password);
        return "hello worlds";
    }
}
