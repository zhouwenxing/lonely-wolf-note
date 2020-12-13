package com.lonely.wolf.note.jvm.overload;

/**
 * 静态分派
 * @author zwx
 * @version 1.0
 * @date 2020/8/12
 * @since jdk1.8
 */
public class OverloadDemo {
    static class Human {

    }

    static class Man extends Human {

    }

    static class WoMan extends Human {

    }

    public void hello(Human human) {
        System.out.println("Hi,Human");
    }

    public void hello(Man man) {
        System.out.println("Hi,Man");
    }

    public void hello(WoMan woMan) {
        System.out.println("Hi,Women");
    }

    public static void main(String[] args) {
        OverloadDemo overloadDemo = new OverloadDemo();
        Human man = new Man();
        Human woman = new WoMan();

        overloadDemo.hello(man);
        overloadDemo.hello(woman);
    }

}
