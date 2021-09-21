package com.ch.demoapp.thread;

/**
 * @author chj
 * @date 2021/8/23 15:40
 */
public class InterruptionInJava implements Runnable {
    private volatile static boolean on = false;
    @Override
    public void run() {
        while (!on) {
            while(!on){
                try {
                    Thread.sleep(10000000);
                } catch (InterruptedException e) {
                    System.out.println("caught exception: "+e);
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread testThread = new Thread(new InterruptionInJava(), "test1");
        testThread.start();
        Thread.sleep(100);
//        testThread.interrupt();
        InterruptionInJava.on = true;
        testThread.interrupt();

        System.out.println("main end");
    }
}
