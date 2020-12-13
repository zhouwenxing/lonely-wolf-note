package com.lonely.wolf.note.design.pattern.state;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/5
 * @since jdk1.8
 */
public class WaitPaidOrderState extends AbstractOrderState {
    public WaitPaidOrderState(OrderContext orderContext) {
        super(orderContext);
    }

    @Override
    public void payOrder() {//相当于待支付的状态绑定了支付行为
        System.out.println("支付成功");
        this.orderContext.setState(this.orderContext.waitDeliver);//切换状态
    }

    @Override
    public void deliver() {
        System.out.println("对不起，请先付钱");
    }

    @Override
    public void receiveGoods() {
        System.out.println("对不起，请先付钱");
    }
}
