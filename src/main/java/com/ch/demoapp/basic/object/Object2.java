package com.ch.demoapp.basic.object;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chj
 * @date 2021/7/19 9:05
 */
public class Object2 {
    public static void main(String[] args) {
        EqualExample example1 = new EqualExample("2");
        EqualExample example2 = new EqualExample("2");
        System.out.println(example1 == example2);
        System.out.println(example1.equals(example2));
        Set<EqualExample> set = new HashSet<>();
        set.add(example1);
        set.add(example2);
        System.out.println(set.size());
        System.out.println(example1.hashCode()+"\n"+example2.hashCode());
    }
}

@Data
@AllArgsConstructor
class EqualExample {
    private String name;

//    @Override
//    public int hashCode() {
//        int result = name.hashCode();
//        result = 17 * result ;
//        return result;
//    }
}
