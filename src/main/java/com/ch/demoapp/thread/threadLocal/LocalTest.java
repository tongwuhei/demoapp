package com.ch.demoapp.thread.threadLocal;

/**
 * @author chj
 * @date 2021/8/26 14:24
 */
public class LocalTest {

    static ThreadLocal<String> localVar = new ThreadLocal<>();

    static void print(String str) {
        System.out.println(str + " :" + localVar.get());
        localVar.remove();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                localVar.set("localVar1");
                print("thread1");
                System.out.println("after remove : " + localVar.get());
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                localVar.set("localVar2");
                print("thread2");
                System.out.println("after remove : " + localVar.get());
            }
        });
        t1.start();
        t2.start();
    }
}
