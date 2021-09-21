package com.ch.demoapp.other;

/**
 * @author chj
 * @date 2021/5/31 15:29
 */
public class Demo1 {
    private String s1;
}

class Demo2 {
    private String s1;
}

class Test {
    public static void main(String[] args) {
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i1 == i2);
        System.out.println(i3.equals(i4));
    }
}
