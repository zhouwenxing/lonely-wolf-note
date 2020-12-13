package com.lonely.wolf.note.design.principle.srp;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/7
 * @since jdk1.8
 */
public class Goods {
    public void action(String type){
        if ("进货".equals(type)){
            System.out.println("我要去进货了");
        }else if("售卖".equals(type)){
            System.out.println("我要卖商品");
        }
    }

    public static void main(String[] args) {
        Goods goods = new Goods();
        goods.action("进货");
    }
}
