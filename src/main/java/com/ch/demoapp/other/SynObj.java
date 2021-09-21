package com.ch.demoapp.other;

/**
 * @author chj
 * @date 2021/6/23 20:50
 */
public class SynObj {
    public synchronized void showA() {
        System.out.println(Thread.currentThread().getName() + "showA..");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void showB() {
        String a = "s";
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "showB..");
        }
    }

    public void showC() {
        String s = "1";
        synchronized (s) {
            System.out.println(Thread.currentThread().getName() + "showC..");
        }
    }

    public static void main(String[] args) {
        final SynObj sy = new SynObj();
        new Thread(new Runnable() {

            @Override
            public void run() {
                sy.showA();
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                sy.showB();
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                sy.showC();
            }
        }).start();
    }
}
