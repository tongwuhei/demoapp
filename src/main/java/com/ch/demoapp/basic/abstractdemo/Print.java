package com.ch.demoapp.basic.abstractdemo;

/**
 * @author chj
 * @date 2021/5/30 16:39
 */
public class Print extends PrintService{
    @Override
    public void out1(String s1) {
        System.out.print(s1);
    }
}

class test{
    public static void main(String[] args) {
        Print print = new Print();
        print.out1("s1\n");
        print.out2("s2");
    }
}
