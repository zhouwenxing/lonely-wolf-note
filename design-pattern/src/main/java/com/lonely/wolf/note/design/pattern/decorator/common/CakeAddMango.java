package com.lonely.wolf.note.design.pattern.decorator.common;

import java.math.BigDecimal;

/**
 * 蛋糕+芒果
 * @author zwx
 * @version 1.0
 * @date 2020/8/2
 * @since jdk1.8
 */
public class CakeAddMango extends Cake {
    @Override
    public String getCakeMsg() {
        return super.getCakeMsg() + "+1个芒果";
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal("10"));
    }
}
