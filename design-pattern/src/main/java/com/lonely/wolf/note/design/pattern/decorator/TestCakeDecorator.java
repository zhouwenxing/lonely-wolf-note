package com.lonely.wolf.note.design.pattern.decorator;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/2
 * @since jdk1.8
 */
public class TestCakeDecorator {
    public static void main(String[] args) {
        Cake cake = null;
        //普通蛋糕
        cake = new BaseCake();
        System.out.println(cake.getCakeMsg() + ",价格：" + cake.getPrice());
        //加一个芒果
        cake = new CakeAddMangoDecorator(cake);
        System.out.println(cake.getCakeMsg() + ",价格：" + cake.getPrice());
        //加一个葡萄
        cake = new CakeAddGrapeDecorator(cake);
        System.out.println(cake.getCakeMsg() + ",价格：" + cake.getPrice());
        //再加一个芒果
        cake = new CakeAddMangoDecorator(cake);
        System.out.println(cake.getCakeMsg() + ",价格：" + cake.getPrice());
    }
}
