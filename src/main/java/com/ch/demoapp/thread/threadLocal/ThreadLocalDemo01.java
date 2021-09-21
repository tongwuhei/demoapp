package com.ch.demoapp.thread.threadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chj
 * @date 2021/8/26 15:04
 */
public class ThreadLocalDemo01 {

    public static ExecutorService threadPool = Executors.newFixedThreadPool(16);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                String data = new ThreadLocalDemo01().date(finalI);
                System.out.println(data);
            });
        }
        threadPool.shutdown();
    }

    private String date(int seconds){
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = ThreadSafeFormater.dateFormatThreadLocal.get();
        return dateFormat.format(date);
    }
}

class ThreadSafeFormater{
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("mm:ss"));
}
