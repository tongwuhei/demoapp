package com.ch.demoapp.basic.collection.safe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chj
 * @date 2021/7/14 9:36
 */
public class list1 {

    public static void main(String[] args) throws InterruptedException {
        List<String> list1 = new ArrayList<>();
        for (int i=0;i<1000;i++){
            new Thread(() -> {
                synchronized (list1) {
                    list1.add(Thread.currentThread().getName());
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list1.size());
    }
}
