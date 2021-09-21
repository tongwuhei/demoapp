package com.ch.demoapp.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chj
 * @date 2021/8/11 20:04
 */
@Component
@Data
public class BeanDependceyB {

    private BeanDependceyA dependceyA;

    @Autowired
    public BeanDependceyB(BeanDependceyA dependceyA){
        this.dependceyA = dependceyA;
    }
}
