package com.lonely.wolf.note.design.pattern.state;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/5
 * @since jdk1.8
 */
public abstract class AbstractOrderState {

    protected OrderContext orderContext;//订单上下文，用来负责状态切换

    public AbstractOrderState(OrderContext orderContext) {
        this.orderContext = orderContext;
    }

    public abstract void payOrder();//待支付状态订单对应的行为：支付

    public abstract void deliver();//已支付状态订单对应的行为：发货

    public abstract void receiveGoods();//已收货状态订单对应的行为：收货
}
