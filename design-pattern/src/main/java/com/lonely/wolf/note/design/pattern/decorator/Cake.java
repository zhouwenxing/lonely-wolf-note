package com.lonely.wolf.note.design.pattern.decorator;

import java.math.BigDecimal;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/2
 * @since jdk1.8
 */
public abstract class Cake {
    public abstract String getCakeMsg();

    public abstract BigDecimal getPrice();
}
