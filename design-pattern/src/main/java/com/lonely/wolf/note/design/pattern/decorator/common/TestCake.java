package com.lonely.wolf.note.design.pattern.decorator.common;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/2
 * @since jdk1.8
 */
public class TestCake {
    public static void main(String[] args) {
        //普通蛋糕
        Cake cake = new Cake();
        System.out.println(cake.getCakeMsg() + ",价格：" + cake.getPrice());

        //加芒果蛋糕
        CakeAddMango cakeAddMango = new CakeAddMango();
        System.out.println(cakeAddMango.getCakeMsg() + ",价格：" + cakeAddMango.getPrice());

        //加芒果和葡萄蛋糕
        CakeAddMangoAndGrape cakeAddMangoAndGrape = new CakeAddMangoAndGrape();
        System.out.println(cakeAddMangoAndGrape.getCakeMsg() + ",价格：" + cakeAddMangoAndGrape.getPrice());
    }
}
