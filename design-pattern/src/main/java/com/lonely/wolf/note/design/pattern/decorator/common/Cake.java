package com.lonely.wolf.note.design.pattern.decorator.common;

import java.math.BigDecimal;

/**
 * 蛋糕
 * @author zwx
 * @version 1.0
 * @date 2020/8/2
 * @since jdk1.8
 */
public class Cake {

    public String getCakeMsg(){
        return "我是一个8英寸的普通蛋糕";
    }

    public BigDecimal getPrice(){
        return new BigDecimal("68");
    }
}
