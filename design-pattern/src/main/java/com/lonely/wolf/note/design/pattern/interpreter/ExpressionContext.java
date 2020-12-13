package com.lonely.wolf.note.design.pattern.interpreter;

import java.util.Stack;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/4
 * @since jdk1.8
 */
public class ExpressionContext {
    private Stack<IExpression> stack = new Stack<>();

    public ExpressionContext(String expression) {
        this.parse(expression);
    }

    private void parse(String expression) {
        String[] elementArr = expression.split(" ");
        for (int i=0;i<elementArr.length;i++){
            String element = elementArr[i];
            if (element.equals("+")){
                IExpression leftExpression = stack.pop();//栈内元素出栈
                IExpression rightExpression = new NumberExpression(elementArr[++i]);//取出+号后的下一个元素
                IExpression addExpression = new AddExpression(leftExpression,rightExpression);
                stack.push(new NumberExpression(addExpression.interpret() + ""));//将计算结果入栈
            }else if (element.equals("-")){
                IExpression leftExpression = stack.pop();//栈内元素出栈
                IExpression rightExpression = new NumberExpression(elementArr[++i]);//取出-号后的下一个元素
                IExpression subExpression = new SubExpression(leftExpression,rightExpression);
                stack.push(new NumberExpression(subExpression.interpret() + ""));//将计算结果入栈
            }else{
                stack.push(new NumberExpression(element));//如果是数字则直接入栈
            }
        }
    }

    public int calcuate(){
        return stack.pop().interpret();//经过前面解析，到这里stack内只会剩下唯一一个数字，即运算结果
    }
}
