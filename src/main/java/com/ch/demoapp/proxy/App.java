package com.ch.demoapp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author chj
 * @date 2021/8/19 20:12
 */
public class App {
    public static void main(String[] args) {

        Hello hello = new ToHello();
        InvocationHandler handler = new TestProxy(hello);

        Hello hello1 = (Hello) Proxy.newProxyInstance(handler.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);

        System.out.println(hello1.getClass().getName());

        hello1.sayHello();
        hello1.run("张三", 123);
    }
}
