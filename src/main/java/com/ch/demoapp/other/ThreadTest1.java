package com.ch.demoapp.other;

/**
 * @author chj
 * @date 2021/6/23 20:20
 */
public class ThreadTest1 {
    private int j;

    public static void main(String args[]) {
        ThreadTest1 tt = new ThreadTest1();
        Inc inc = tt.new Inc();
        Dec dec = tt.new Dec();
        Thread t = new Thread(inc);
        t.start();
        t = new Thread(dec);
        t.start();
    }

    private synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
    }

    private synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + "-dec:" + j);
    }

    class Inc implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                dec();
            }
        }
    }
}
