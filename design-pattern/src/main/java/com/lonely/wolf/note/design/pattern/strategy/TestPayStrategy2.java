package com.lonely.wolf.note.design.pattern.strategy;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/3/2
 * @since jdk1.8
 */
public class TestPayStrategy2 {

    public static void main(String[] args) {
        IPayStrategy IPayStrategy = PayEnum.getValue("aliPay");
        IPayStrategy.pay(10);
        IPayStrategy.queryBalance();
    }
}
