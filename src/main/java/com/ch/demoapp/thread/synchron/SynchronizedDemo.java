package com.ch.demoapp.thread.synchron;

/**
 * @author chj
 * @date 2021/6/2 17:40
 * <p>
 * synchronized的三个基本规则 >>
 * <p>
 * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
 * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程仍然可以访问“该对象”的非同步代码块。
 * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程对“该对象”的其他的“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
 */
public class SynchronizedDemo implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    //休眠100ms
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
//        //新建runnable对象
//        Runnable demo = new SynchronizedDemo();1363745

//        //新建“线程1”，t1是基于demo这个Runnable对象
//        Thread t1 = new Thread(demo, "t1");
//        //新建“线程2”，t2是基于demo这个Runnable对象
//        Thread t2 = new Thread(demo, "t2");
//        t1.start();
//        t2.start();

        //新建两个线程
        Thread t1 = new MyThread("t1");
        Thread t2 = new MyThread("t2");
        //启动该两个线程
        t1.start();
        t2.start();
    }
}
