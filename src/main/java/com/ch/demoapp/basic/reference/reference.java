package com.ch.demoapp.basic.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author chj
 * @date 2021/5/31 16:13
 */
public class reference {

    /**
     * 强引用
     * 使用最多，在程序内存不足的时候（OOM）也不会被回收
     */
    static String str = new String("sss");
    /**
     * 弱引用
     * 只要JVM垃圾回收器发现了它，就会将之回收
     */
    static WeakReference<String> str3 = new WeakReference<String>(new String("ewq"));

    /**
     * 软引用
     * 在程序内存不足的时候就会被回收
     */
    static SoftReference<String> str2 = new SoftReference<String>(new String("sss2"));

    /**
     * 虚引用
     * 虚引用的回收机制跟弱引用差不多，但是它被回收之前，会被放入 ReferenceQueue 中。注意
     * 的是，其它引用是被JVM回收后才被传入 ReferenceQueue 中的。由于这个机制，所以虚引用大多
     * 被用于引用销毁前的处理工作。还有就是，虚引用创建的时候，必须带有 ReferenceQueue ，如下创建方式
     */
    static PhantomReference<String> str4 = new PhantomReference<String>(new String("s"),new ReferenceQueue<>());

    public static void main(String[] args) {
        System.out.println(str);
        System.out.println(str2.toString());
        System.out.println(str3);
        System.out.println(str4);
    }
}
