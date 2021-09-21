package com.ch.demoapp.bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 测试bean的循环依赖
 * @author chj
 * @date 2021/8/11 20:06
 */
@Configuration
@ComponentScan(basePackages = {"com.ch.demoapp.bean"})
public class BeanConfig {
}


