package com.ch.demoapp.thread.runabledemo;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chj
 * @date 2021/6/27 16:44
 */
public class test2 implements Runnable {
    private AtomicInteger num = new AtomicInteger(10);

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            if (num.get() <= 0) {
                break;
            }
            Thread.sleep(10);
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + num.getAndDecrement() + "--张票");
        }
    }

    public static void main(String[] args) {
        test2 t = new test2();

        new Thread(t, "张三").start();
        new Thread(t, "李四").start();
        new Thread(t, "王五").start();
    }
}
