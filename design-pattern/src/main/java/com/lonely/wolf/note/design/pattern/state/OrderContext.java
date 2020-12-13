package com.lonely.wolf.note.design.pattern.state;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/5
 * @since jdk1.8
 */
public class OrderContext {
    AbstractOrderState waitPaid;
    AbstractOrderState waitDeliver;
    AbstractOrderState receiveGoods;

    AbstractOrderState currState;//当前状态

    public OrderContext() {
        this.waitPaid = new WaitPaidOrderState(this);
        this.waitDeliver = new WaitDeliverOrderState(this);
        this.receiveGoods = new ReceiveGoodsOrderState(this);
        currState = waitPaid;
    }

    void setState(AbstractOrderState state){
        this.currState = state;
    }

    public void payOrder(){
        currState.payOrder();
    }


    public void deliver(){
        currState.deliver();
    }

    public void receiveGoods(){
        currState.receiveGoods();
    }

}
