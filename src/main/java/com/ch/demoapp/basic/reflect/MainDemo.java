package com.ch.demoapp.basic.reflect;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author chj
 * @date 2021/5/30 17:02
 */
@Data
public class MainDemo {

    private String id;
    private String user;
    private String password;

    public void display(){
        System.out.println("Hello");
    }


    public static void main(String[] args) {

        System.out.println(3 * 0.1 == 0.3);

        Integer a[] = new Integer[4];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        List list = new ArrayList();
        list = Arrays.asList(a.clone());
        System.out.println("list的值为： "+ list);
        // 迭代器
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer n = iterator.next();
            System.out.println(n);
            if (n==2){
                iterator.remove();
            }
        }
        System.out.println("list的值为： "+ list);

    }
}
