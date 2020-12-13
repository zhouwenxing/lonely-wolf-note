package com.lonely.wolf.note.design.pattern.interpreter;

/**
 * 非终结表达式-数值表达式
 * @author zwx
 * @version 1.0
 * @date 2020/10/4
 * @since jdk1.8
 */
public class NumberExpression implements IExpression{
    private int value;

    public NumberExpression(String value) {
        this.value = Integer.valueOf(value);
    }

    @Override
    public int interpret() {
        return this.value;
    }
}
