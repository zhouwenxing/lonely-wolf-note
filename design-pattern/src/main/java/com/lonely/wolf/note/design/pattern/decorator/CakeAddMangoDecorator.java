package com.lonely.wolf.note.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/2
 * @since jdk1.8
 */
public class CakeAddMangoDecorator extends CakeDecorator {

    public CakeAddMangoDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public String getCakeMsg() {
        return super.getCakeMsg() + "+1个芒果";
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal("10"));
    }
}
