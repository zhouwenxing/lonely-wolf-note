package com.lonely.wolf.note.design.pattern.state;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/5
 * @since jdk1.8
 */
public class WaitDeliverOrderState extends AbstractOrderState {
    public WaitDeliverOrderState(OrderContext orderContext) {
        super(orderContext);
    }

    @Override
    public void payOrder() {
        System.out.println("你已经付过钱了");
    }

    @Override
    public void deliver() {
        System.out.println("商品已发货并送达目的地");
        this.orderContext.setState(this.orderContext.receiveGoods);//切换状态
    }

    @Override
    public void receiveGoods() {
        System.out.println("请稍等，商品即将发货");
    }
}
