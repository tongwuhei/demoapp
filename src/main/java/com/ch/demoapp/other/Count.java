package com.ch.demoapp.other;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chj
 * @date 2021/6/24 15:17
 */
public class Count {
    private int count = 0;

    private AtomicInteger atomicI = new AtomicInteger(0);

    /**
     * 线程不安全的计数器
     */
    public void count() {
        count++;
    }

    /**
     * 线程安全的计数器，循环CAS
     */
    public void safeCount() {
        for (; ; ) {
            int temp = atomicI.get();
            if (atomicI.compareAndSet(temp, ++temp)) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        final Count cas = new Count();
        List<Thread> list = new ArrayList();
        long start = System.currentTimeMillis();
        for (int j = 0; j < 10; j++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            list.add(t);
        }
        //启动线程
        for (Thread t : list) {
            t.start();
        }
        //等待所有线程执行完毕
        for (Thread t : list) {
            try {
                t.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程不安全:" + cas.count);
        System.out.println("线程安全:" + cas.atomicI.get());
        System.out.println("耗时:" + (System.currentTimeMillis() - start));
    }

}
