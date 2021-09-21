package com.ch.test;

import java.io.IOException;

/**
 * @author chj
 * @date 2021/9/7 18:33
 */
public class test1 {
    private static Object t1 = new Object();
    private static Object t2 = new Object();

    public static void main(String[] args) throws IOException {
//        Runtime.getRuntime().exec("ss");
        new Thread(() -> {
            synchronized (t1) {
                System.out.println("线程1已持有t1锁");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (t2) {
                    System.out.println("线程1已持有t2锁");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (t1) {
                System.out.println("线程2已持有t1锁");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (t2) {
                    System.out.println("线程2已持有t2锁");
                }
            }
        }).start();
    }
}
