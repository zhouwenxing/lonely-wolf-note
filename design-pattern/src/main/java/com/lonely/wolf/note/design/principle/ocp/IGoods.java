package com.lonely.wolf.note.design.principle.ocp;

import java.math.BigDecimal;

/**
 * 开闭原则
 * @author zwx
 * @version 1.0
 * @date 2020/10/7
 * @since jdk1.8
 */
public interface IGoods {

    String getName();

    BigDecimal getSalePrice();
}
