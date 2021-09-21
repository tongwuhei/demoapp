package com.ch.demoapp.thread.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author chj
 * @date 2021/9/2 16:43
 */
public class CasTest {
    private static AtomicInteger index = new AtomicInteger(10);
    private static AtomicStampedReference<Integer> stampRef = new AtomicStampedReference<>(10, 1);

    public static void main(String[] args) {
        new Thread(() -> {
            index.compareAndSet(10, 11);
            index.compareAndSet(11, 10);
            System.out.println(Thread.currentThread().getName() + " : 10 -> 11 ->10");
        }, "张三").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                boolean isSuccess = index.compareAndSet(10, 12);
                System.out.println(Thread.currentThread().getName() + " : index设计预期的10？" + isSuccess + "  设置的新值为：" + index.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "李四").start();
    }
}
