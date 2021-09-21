package com.ch.demoapp.proxy;

/**
 * @author chj
 * @date 2021/8/19 20:13
 */
public class ToHello implements Hello {
    @Override
    public void sayHello() {
        System.out.println("哈啰");
    }

    @Override
    public void run(String name, int count) {
        System.out.println(name + "  " + count);
    }
}
