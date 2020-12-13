package com.lonely.wolf.note.design.principle.ocp;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/12
 * @since jdk1.8
 */
public class TestOCP {
    public static void main(String[] args) {
        System.out.println("蔬菜原价：" + new Cabbage().getSalePrice());//获取蔬菜原价
        System.out.println("蔬菜打折价：" + new DiscountCabbage().getSalePrice());//获取蔬菜打折价
    }
}
