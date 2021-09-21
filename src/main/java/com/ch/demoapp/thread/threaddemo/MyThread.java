 package com.ch.demoapp.thread.threaddemo;

/**
 * @author chj
 * @date 2021/6/2 16:36
 */
public class MyThread extends Thread {
    private Integer num = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (this.num > 0) {
                System.out.println(this.getName() + "输出：num = "+ this.num--);
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        for (int i = 0;i<10;i++){
            System.out.println("sss");
        }


    }
}
