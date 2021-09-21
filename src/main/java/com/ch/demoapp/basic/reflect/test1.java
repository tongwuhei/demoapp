package com.ch.demoapp.basic.reflect;

import lombok.Data;

import java.lang.reflect.Field;

/**
 * 反射获取对象私有属性的值
 *
 * @author chj
 * @date 2021/7/14 19:07
 */
public class test1 {
    public static void main(String[] args) throws NoSuchFieldException {
        Za za = new Za();
        za.setName("张三");
        Field fields[] = za.getClass().getDeclaredFields();
        String[] name = new String[fields.length];
        Object[] value = new Object[fields.length];
        try {
            Field.setAccessible(fields, true);
            for (int i = 0; i < name.length; i++) {
                name[i] = fields[i].getName();
                value[i] = fields[i].get(za);
                System.out.println(name[i] + "-->" + value[i]);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}

@Data
class Za {
    private String name;
}
