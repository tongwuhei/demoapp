package com.ch.demoapp.basic.reflect;

import com.ch.demoapp.sql.entity.Student;

/**
 * @author chj
 * @date 2021/6/1 16:46
 */
public class reflect {

    /**
     * 几种获取Class的方式
     * 注意 在运行期间，一个类只有一个Class对象产生
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        /**
         * 第一种方式获取Class对象
         * 这一new 产生一个Student对象，一个Class对象。
         */
        MainDemo demo = new MainDemo();
        //获取Class对象
        Class demo1 = demo.getClass();
        System.out.println(demo1.getName());

        //第二种方式获取Class对象
        Class demo2 = MainDemo.class;
        //判断第一种方式获取的Class对象和第二种方式获取的是否是同一个
        System.out.println(demo1 == demo2);

        //第三种方式获取Class对象

        //注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
        Class demo3 = Class.forName("com.ch.demoapp.basic.reflect.MainDemo");
        //判断三种方式是否获取的是同一个Class对象
        System.out.println(demo3 == demo1);

        Object object = (Object) Class.forName("com.ch.demoapp.basic.reflect.MainDemo").newInstance();
//        Method method = object.getClass().getMethod("display",void.class);

    }

}
