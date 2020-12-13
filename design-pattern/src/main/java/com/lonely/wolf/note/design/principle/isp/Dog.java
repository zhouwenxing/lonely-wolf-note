package com.lonely.wolf.note.design.principle.isp;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/7
 * @since jdk1.8
 */
public class Dog implements IRunAnimal,ISwimAnimal {

    @Override
    public void run() {
        System.out.println("我跑的很快");
    }

    @Override
    public void swim() {
        System.out.println("我还会游用");
    }
}
