package com.ch.demoapp.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chj
 * @date 2021/7/14 17:27
 */
public class TestPool {
    public static void main(String[] args) {
        //创建服务，创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        //执行
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        /**
         * execute和submit的区别：
         * 1、前者有返回值，后者无返回值
         * 2、execute只能提交Runnable类型的任务，而submit既能提交Runnable类型任务也能提交Callable类型任务
         */
        service.execute(new MyThread());
        service.submit(new MyThread());

        //关闭链接
        service.shutdown();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName  ());
        }
    }
}