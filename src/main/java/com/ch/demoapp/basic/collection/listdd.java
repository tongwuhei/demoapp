package com.ch.demoapp.basic.collection;

import java.util.ArrayList;

/**
 * @author chj
 * @date 2021/5/31 16:00
 */
public class listdd {
    ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>(list);
        list.add(6);
    }
}
