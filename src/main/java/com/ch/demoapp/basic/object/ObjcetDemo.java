package com.ch.demoapp.basic.object;

import lombok.Data;

/**
 * @author chj
 * @date 2021/5/31 16:29
 */
@Data
public class ObjcetDemo implements Cloneable{

    private String s;

    private Demo2 demo2;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void updateDemo2(String s) {
        this.demo2.setAa(s);
    }
}
@Data
class Demo2 {
    private String aa;
}

class test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Demo2 demo2 = new Demo2();
        demo2.setAa("ac");
        ObjcetDemo demo = new ObjcetDemo();
        demo.setS("s");
        demo.setDemo2(demo2);
        /**
         * 调用一个对象的clone方法，必须要让该类实现Cloneable接口，然后覆写clone方法
         *
         * 下面是 “浅克隆” ；只是复制了其引用，例如，类中有一个字段为引用类型，则复制该引用，不复制该对象，修改其中一个对象的引用对象，另一个也会变
         * 因为它们指向的是同一块堆内存空间
         */
        ObjcetDemo demo3 = (ObjcetDemo) demo.clone();
        System.out.println(demo.getDemo2()+"----"+demo3.getDemo2());
        demo.updateDemo2("new");
        System.out.println(demo.getDemo2()+"----"+demo3.getDemo2());
    }

}
