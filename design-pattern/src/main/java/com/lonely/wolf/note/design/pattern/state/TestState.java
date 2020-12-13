package com.lonely.wolf.note.design.pattern.state;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/5
 * @since jdk1.8
 */
public class TestState {
    public static void main(String[] args) {
        OrderContext orderContext = new OrderContext();
        orderContext.payOrder();
        orderContext.deliver();
        orderContext.receiveGoods();
    }
}
