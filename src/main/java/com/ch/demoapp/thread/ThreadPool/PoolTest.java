package com.ch.demoapp.thread.ThreadPool;

import java.util.concurrent.*;

/**
 * @author chj
 * @date 2021/8/31 9:22
 */
public class PoolTest implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行。。。");
    }

    public static void main(String[] args) {
        ExecutorService service1 = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

        ExecutorService service = Executors.newCachedThreadPool();
        Thread test1 = new Thread(new PoolTest(), "t1");
        Thread test2 = new Thread(new PoolTest(), "t2");
        Thread test3 = new Thread(new PoolTest(), "t3");
        service.execute(test1);
        service.execute(test2);
        service.execute(test3);
        service.shutdown();
    }
}
