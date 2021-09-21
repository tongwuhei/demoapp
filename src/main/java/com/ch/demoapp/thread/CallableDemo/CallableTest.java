package com.ch.demoapp.thread.CallableDemo;

import java.util.concurrent.*;

/**
 * @author chj
 * @date 2021/6/28 19:35
 */
public class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("ss");
        return "hello world";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest call = new CallableTest();
        ExecutorService service = Executors.newFixedThreadPool(10);
//        service.execute(call);
        service.submit(call);
        //关闭线程池
        service.shutdown();
    }
}
