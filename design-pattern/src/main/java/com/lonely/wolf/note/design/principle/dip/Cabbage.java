package com.lonely.wolf.note.design.principle.dip;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/7
 * @since jdk1.8
 */
public class Cabbage implements IGoods{
    @Override
    public void sale() {
        System.out.println("我有白菜卖");
    }
}
