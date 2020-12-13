package com.lonely.wolf.note.design.pattern.strategy.impl;

import com.lonely.wolf.note.design.pattern.strategy.IPayStrategy;

import java.math.BigDecimal;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/3/2
 * @since jdk1.8
 */
public class AliPayStrategy implements IPayStrategy {
    @Override
    public boolean pay(int money) {
        System.out.println("支付宝支付成功");
        return true;
    }

    @Override
    public BigDecimal queryBalance() {
        System.out.println("支付宝余额10元");
        return new BigDecimal(10);
    }
}
