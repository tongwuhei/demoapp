package com.ch.demoapp.other;

/**
 * @author chj
 * @date 2021/6/26 11:17
 */
@SuppressWarnings("all")
public class test2 {
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("线程1，开始获取obj1锁");
            synchronized (obj1) {
                System.out.println("线程1，获取obj1锁成功");
                System.out.println("线程1，开始获取obj2锁");
                //休眠让两个线程都获取到对应的锁
                sleep(1);
                synchronized (obj2) {
                    System.out.println("线程1，获取obj2锁成功");
                }
            }
        });
        t.start();

        Thread t2 = new Thread(() -> {
            System.out.println("线程2，开始获取obj2锁");
            synchronized (obj2) {
                System.out.println("线程2，获取obj2锁成功");
                System.out.println("线程2，开始获取obj1锁");
                sleep(1);
                synchronized (obj1) {
                    System.out.println("线程2，获取obj1锁成功");
                }
            }
        });
        t2.start();
        t2.join();
    }

    public static void sleep(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
