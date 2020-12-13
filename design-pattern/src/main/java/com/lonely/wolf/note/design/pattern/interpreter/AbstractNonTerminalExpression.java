package com.lonely.wolf.note.design.pattern.interpreter;

/**
 * 非终结表达式-抽象表达式
 * @author zwx
 * @version 1.0
 * @date 2020/10/4
 * @since jdk1.8
 */
public abstract class AbstractNonTerminalExpression implements IExpression{
    protected IExpression leftExpression;
    protected IExpression rightExpression;

    public AbstractNonTerminalExpression(IExpression leftExpression, IExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
}
