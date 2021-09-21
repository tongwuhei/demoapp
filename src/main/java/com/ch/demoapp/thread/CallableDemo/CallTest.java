package com.ch.demoapp.thread.CallableDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author chj
 * @date 2021/8/22 16:46
 */
public class CallTest implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "  call()方法执行中");
        return 0;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new CallTest());
        new Thread(futureTask).start();
        System.out.println("返回结果为：  " + futureTask.get());
        System.out.println(Thread.currentThread().getName() + " main()方法执行完成");
    }
}
