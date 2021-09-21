package com.ch.demoapp.thread.threaddemo;

/**
 * @author chj
 * @date 2021/6/28 14:58
 */
public class Thread1 extends Thread {

    private String name;

    /**
     * 定义共享的数据100张票
     */
    static int tickets = 20;

    //创建一个锁对象，这个对象是多个线程对象共享的数据
    static Object obj = new Object();

    public Thread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        //卖票是持续的
        while (true) {
            synchronized (obj) {
                if (tickets > 0) {
                    System.out.println(name + "卖出座位是" + (tickets--) + "号");
                } else {
                    break;
                }
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + "卖票结束");
    }

    public static void main(String[] args) {
        Thread1 t1 = new Thread1("窗口1");

        Thread1 t2 = new Thread1("窗口2");
        Thread1 t3 = new Thread1("窗口3");
        Thread1 t4 = new Thread1("窗口4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
