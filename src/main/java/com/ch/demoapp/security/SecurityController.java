package com.ch.demoapp.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chj
 * @date 2021/5/31 15:10
 */
@RestController
public class SecurityController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
