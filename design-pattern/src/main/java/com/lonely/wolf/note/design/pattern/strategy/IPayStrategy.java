package com.lonely.wolf.note.design.pattern.strategy;

import java.math.BigDecimal;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/3/2
 * @since jdk1.8
 */
public interface IPayStrategy {

    boolean pay(int money);

    BigDecimal queryBalance();
}
