package com.lonely.wolf.note.design.pattern.interpreter;

/**
 * 非终结表达式-具体表达式-减法表达式
 * @author zwx
 * @version 1.0
 * @date 2020/10/4
 * @since jdk1.8
 */
public class SubExpression extends AbstractNonTerminalExpression {

    public SubExpression(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public int interpret() {
        return this.leftExpression.interpret() - this.rightExpression.interpret();
    }
}
