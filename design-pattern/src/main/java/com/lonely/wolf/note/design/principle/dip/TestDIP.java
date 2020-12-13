package com.lonely.wolf.note.design.principle.dip;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/10
 * @since jdk1.8
 */
public class TestDIP {
    public static void main(String[] args) {
        SuperMarket superMarket = new SuperMarket();
        superMarket.sale(new Cabbage());//输出：
    }
}
