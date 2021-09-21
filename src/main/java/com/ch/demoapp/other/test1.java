package com.ch.demoapp.other;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chj
 * @date 2021/6/24 19:50
 */
public class test1 {
    public static AtomicInteger count = new AtomicInteger(0);

    @SuppressWarnings("all")
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < 100; j++) {
//                        synchronized (test1.class){
//                            count++;
//                        }
                        count.incrementAndGet();
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count ==  " + count);
    }
}
