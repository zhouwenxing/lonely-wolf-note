package com.lonely.wolf.note.design.principle.isp;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/12
 * @since jdk1.8
 */
public class TestISP {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.run();//狗会跑
        dog.swim();//狗会游泳
    }
}
