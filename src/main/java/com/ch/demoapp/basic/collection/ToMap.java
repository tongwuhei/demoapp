package com.ch.demoapp.basic.collection;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chj
 * @date 2021/7/20 20:25
 */
public class ToMap {
    public static void main(String[] args) {
        List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
        pairArrayList.add(new Pair<>("ss", 1.1));
        pairArrayList.add(new Pair<>("ss", 1.2));
        pairArrayList.add(new Pair<>("ss", 1.3));
        Map<String, Double> map = pairArrayList.stream().collect(
                Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2)
        );
        map.forEach((key, value) -> {
            System.out.println(key + "-->" + value);
        });
    }
}
