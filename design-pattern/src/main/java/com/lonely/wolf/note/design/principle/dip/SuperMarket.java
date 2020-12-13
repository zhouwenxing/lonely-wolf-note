package com.lonely.wolf.note.design.principle.dip;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/7
 * @since jdk1.8
 */
public class SuperMarket {
    public void sale(IGoods goods){
        goods.sale();
    }
}
