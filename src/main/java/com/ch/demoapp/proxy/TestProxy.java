package com.ch.demoapp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chj
 * @date 2021/8/19 20:03
 */
public class TestProxy implements InvocationHandler {

    //需要代理的真实对象
    private Object target;

    public TestProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("123");
        System.out.println("method: " + method);

        method.invoke(target, args);

        System.out.print("456");
        System.out.println("");
        return null;
    }
}
