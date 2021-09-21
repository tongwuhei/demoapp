package com.ch.demoapp.basic.abstractdemo;

/**
 * @author chj
 * @date 2021/5/30 16:38
 */
public abstract class PrintService {
    private String ss;

    public abstract void out1(String s1);

    public void out2(String s2){
        System.out.println(s2);
    }
}
