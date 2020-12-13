package com.lonely.wolf.note.design.pattern.decorator.common;

import java.math.BigDecimal;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/2
 * @since jdk1.8
 */
public class CakeAddMangoAndGrape extends CakeAddMango {
    @Override
    public String getCakeMsg() {
        return super.getCakeMsg() + "+1个葡萄";
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal("5"));
    }
}
