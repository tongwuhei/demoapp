package com.ch.demoapp.thread.runabledemo;

/**
 * @author chj
 * @date 2021/6/2 16:51
 */
public class MyThread implements Runnable {
    private Integer num = 10;

    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "输出：num = " + this.num--);
            }
        }
    }
}

class RunnableTest {
    public static void main(String[] args) {
        MyThread mt = new MyThread();

        //启动三个线程t1,t2,t3,(它们公用一个Runnable对象，这三个线程一共输出十个结果)
        new Thread(mt).start();
        Thread t2 = new Thread(mt);
        Thread t3 = new Thread(mt);

        t2.start();
        t3.start();

    }
}
