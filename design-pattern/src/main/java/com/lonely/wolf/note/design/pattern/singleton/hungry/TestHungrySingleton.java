package com.lonely.wolf.note.design.pattern.singleton.hungry;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/17
 * @since jdk1.8
 */
public class TestHungrySingleton {
    public static void main(String[] args) {
        //测试普通写法
        HungrySingleton singleton1  = HungrySingleton.getInstance();
        HungrySingleton singleton2  = HungrySingleton.getInstance();
        System.out.println(singleton1 == singleton2);//输出:true

        //测试静态类写法
        HungryStaticSingleton singleton3 = HungryStaticSingleton.getInstance();
        HungryStaticSingleton singleton4 = HungryStaticSingleton.getInstance();
        System.out.println(singleton3 == singleton4);//输出:true
    }
}
