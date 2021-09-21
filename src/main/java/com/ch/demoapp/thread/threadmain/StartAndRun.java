package com.ch.demoapp.thread.threadmain;

/**
 * @author chj
 * @date 2021/6/2 17:07
 */
public class StartAndRun extends Thread {

    public StartAndRun(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}

class Test {
    public static void main(String[] args) {
        Thread sar = new StartAndRun("myThread");
        System.out.println(Thread.currentThread().getName() + " call sar.run()");
        sar.run();

        System.out.println(Thread.currentThread().getName() + " call sar.start()");
        sar.start();
    }
}

/**
 * 结果说明 >>
 * (01) Thread.currentThread().getName()是用于获取“当前线程”的名字。当前线程是指正在cpu中调度执行的线程。
 * (02) mythread.run()是在“主线程main”中调用的，该run()方法直接运行在“主线程main”上。
 * (03) mythread.start()会启动“线程mythread”，“线程mythread”启动之后，会调用run()方法；此时的run()方法是运行在“线程mythread”上。
 */