package com.lonely.wolf.note.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/2
 * @since jdk1.8
 */
public class BaseCake extends Cake {
    @Override
    public String getCakeMsg() {
        return "我是一个8英寸的普通蛋糕";
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("68");
    }
}
