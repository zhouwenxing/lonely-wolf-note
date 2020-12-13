package com.lonely.wolf.note.design.pattern.state;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/5
 * @since jdk1.8
 */
public class ReceiveGoodsOrderState extends AbstractOrderState{
    public ReceiveGoodsOrderState(OrderContext orderContext) {
        super(orderContext);
    }

    @Override
    public void payOrder() {
        System.out.println("您已经付过钱啦，不要重复付钱哦");
    }

    @Override
    public void deliver() {
        System.out.println("商品已发货并送达，请不要重复发货");
    }

    @Override
    public void receiveGoods() {
        System.out.println("用户已收到商品，此次交易结束");
    }
}
