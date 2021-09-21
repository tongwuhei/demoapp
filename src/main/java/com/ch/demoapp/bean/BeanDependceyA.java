package com.ch.demoapp.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author chj
 * @date 2021/8/11 20:04
 */
@Component
@Scope()
public class BeanDependceyA {

    @Autowired
    private BeanDependceyB dependceyB;

    public BeanDependceyB getDependceyB() {
        return dependceyB;
    }

    @PostConstruct
    public void init() {
        dependceyB.setDependceyA(this);
    }
}
