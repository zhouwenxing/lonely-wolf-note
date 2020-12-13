package com.lonely.wolf.note.design.principle.ocp;

import java.math.BigDecimal;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/7
 * @since jdk1.8
 */
public class Cabbage implements IGoods {
    @Override
    public String getName() {
        return "上海青";
    }

    @Override
    public BigDecimal getSalePrice() {
        return new BigDecimal("2.98");
    }
}
