package com.ch.demoapp.thread.PC;

/**
 * 测试生产者消费者模型———>利用缓冲区解决：管程法
 *
 * @author chj
 * @date 2021/7/14 15:16
 */
public class TestPc {
    public static void main(String[] args) {
        synContainer synContainer = new synContainer();
        scz scz = new scz(synContainer);
        xfz xfz = new xfz(synContainer);
        scz.start();
        xfz.start();
    }
}

//生产者
class scz extends Thread {
    synContainer synContainer;

    public scz(synContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            synContainer.push(new Chicken(i));
            System.out.println("产生了" + i + "只鸡");
        }
    }
}

//消费者
class xfz extends Thread {
    synContainer synContainer;

    public xfz(synContainer synContainer) {
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            synContainer.pop();
            System.out.println("消费了第" + i + "只鸡");
        }
    }
}

//产品
class Chicken {
    int id;//产品编号

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区域
class synContainer {
    //容器大小
    Chicken[] chickens = new Chicken[10];
    int count = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken) {
        //如果满了需要等待消费者消费
        if (count == 10) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count] = chicken;
        count++;
        this.notifyAll();
    }

    public synchronized Chicken pop() {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        return chicken;
    }
}