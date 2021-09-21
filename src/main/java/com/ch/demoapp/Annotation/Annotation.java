package com.ch.demoapp.Annotation;

/**
 * @author chj
 * @date 2021/6/25 16:22
 */
public class Annotation {

    @adminOnly()
    private String name;

    @adminOnly()
    String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        Annotation ann = new Annotation();
        System.out.println(ann.getName());
    }
}
