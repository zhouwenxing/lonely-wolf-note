package com.lonely.wolf.note.design.pattern.interpreter;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/4
 * @since jdk1.8
 */
public class TestInterpreter {

    public static void main(String[] args) {
        ExpressionContext context = new ExpressionContext("666 + 888 - 777");//注意每个符号间要包含空格
        System.out.println(context.calcuate());//输出计算结果
        context = new ExpressionContext("123 - 456 + 11");
        System.out.println(context.calcuate());//输出计算结果
    }
}
