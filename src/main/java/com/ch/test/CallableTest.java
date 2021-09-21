package com.ch.test;

import javax.swing.table.TableRowSorter;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author chj
 * @date 2021/9/7 19:30
 */
public class CallableTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        System.out.println("call 方法正在执行");
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest callableTest = new CallableTest();
        FutureTask<Integer> task = new FutureTask<Integer>(callableTest);
        new Thread(task,"线程1").start();
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName());
        System.out.println("返回结果：" + task.get());
        System.out.println(Thread.currentThread().getName());
    }
}
