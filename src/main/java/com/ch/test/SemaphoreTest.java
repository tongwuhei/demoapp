package com.ch.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author chj
 * @date 2021/9/20 19:21
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        //创建10个容量的线程池
        final ExecutorService service = Executors.newFixedThreadPool(100);
        //设置信号量的值5 ，也就是允许五个线程来执行
        Semaphore s = new Semaphore(5);
        for (int i = 0; i < 20; i++) {
            service.submit(() ->{
                try {
                    s.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println("数据库耗时操作"+Thread.currentThread().getName());
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在执行....");
                s.release();
            });
        }

    }
}
