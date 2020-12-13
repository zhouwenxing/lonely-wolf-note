package com.lonely.wolf.note.design.principle.srp;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/12
 * @since jdk1.8
 */
public class TestSRP {
    public static void main(String[] args) {
        //不符合单一职责写法
        Goods goods = new Goods();
        goods.action("进货");//输出：我要去进货了
        goods.action("售卖");//输出：我要卖商品

        //符合单一职责写法
        BuyGoods buyGoods = new BuyGoods();
        buyGoods.action();//输出：我要去进货了
        SaleGoods saleGoods = new SaleGoods();
        saleGoods.action();//输出：我要卖商品
    }
}
