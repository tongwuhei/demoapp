package com.ch.demoapp.basic.compare;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author chj
 * @date 2021/8/15 16:36
 */
public class CompareTest {

    public static void main(String[] args) {

        User user1 = new User("张三", 10);
        User user2 = new User("李四", 15);
        User user3 = new User("王五", 5);
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        Collections.sort(users);
        users.forEach(user -> System.out.println(user.toString()));
        System.out.println(user1.compareTo(user2));
    }


    @AllArgsConstructor
    @NoArgsConstructor
    static
    class User implements Comparable<User> {
        private String name;
        private Integer age;

        @Override
        public String toString() {
            return "姓名：" + name + "  年龄：" + age;
        }

        @Override
        public int compareTo(User user) {
            if (this.age > user.age) {
                return 1;
            } else if (this.age < user.age) {
                return -1;
            }
            return 0;
        }
    }
}
