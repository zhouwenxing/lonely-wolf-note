package com.lonely.wolf.note.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/2
 * @since jdk1.8
 */
public abstract class CakeDecorator extends Cake{
    private Cake cake;

    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }

    @Override
    public String getCakeMsg() {
        return this.cake.getCakeMsg();
    }

    @Override
    public BigDecimal getPrice() {
        return this.cake.getPrice();
    }
}
