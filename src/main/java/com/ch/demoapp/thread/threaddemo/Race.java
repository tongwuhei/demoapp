package com.ch.demoapp.thread.threaddemo;

import lombok.SneakyThrows;

/**
 * @author chj
 * @date 2021/6/28 19:09
 */
public class Race implements Runnable {

    private static String winner;

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (Thread.currentThread().getName().equals("兔子") && i == 20) {
                Thread.sleep(1);
            }
            if (gameOver(i)) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "——>跑了" + i + "步");
        }
    }

    private boolean gameOver(int step) {
        if (winner != null) {
            return true;
        }
        if (step >= 100) {
            winner = Thread.currentThread().getName();
            System.out.println("winner is " + winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
