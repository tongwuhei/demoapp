package com.ch.demoapp;

import com.ch.demoapp.bean.BeanConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { BeanConfig.class })
class DemoappApplicationTests {

    @Test
    void contextLoads() {
    }

}
