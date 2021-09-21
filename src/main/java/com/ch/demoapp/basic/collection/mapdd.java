package com.ch.demoapp.basic.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chj
 * @date 2021/5/31 15:57
 */
public class mapdd {
    public static void main(String[] args) {
        /**
         * HashMap  //   HashTable
         *
         * 安全方面
         * HashMap线程不安全，多线程并发的情况下，可能产生死锁
         * HashTable是线程安全的，它的每个方法上都有synchronized关键字，可直接用于多线程
         *
         * 效率方面
         * HashMap效率远高于HashTable
         *
         * 如果需要线程安全高并发，推荐使用ConcurrentHashMap（）代替HashTable
         *
         * :TODO：ConcurrentHashMap深入学习
         *
         */
        Map<String, String> map1 = new HashMap<>();
        map1.put("a", "b");
        map1.put(null, null);
        map1.put("b", "c");
        Map<String, String> map2 = new Hashtable<>();
        map2.put("s", "s");
        map1.forEach((s, s3) -> System.out.println(s3));

        Map<String, String> currentMap = new ConcurrentHashMap<>();
        currentMap.put("key1","value1");
        currentMap.put("key2","value2");
        System.out.println(currentMap.toString());

    }
}
