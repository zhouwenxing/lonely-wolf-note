package com.lonely.wolf.note.initSort;

/**
 * 测试变量顺序
 * @author zwx
 * @version 1.0
 * @date 2020/8/28
 * @since jdk1.8
 */
public class TestVariableOrder {
    public static void main(String[] args) {
//        System.out.println(SuperInitVariable.superStaticStr);
//        SuperInitVariable superInitVariable = new SuperInitVariable();
//        System.out.println(superInitVariable.superInstanceStr);
//        System.out.println(SubInitVariable.subStaticStr);
//        SubInitVariable subInitVariable = new SubInitVariable();

        //测试引用变量和数组
        System.out.println("输出数组：" + InitReferenceVariable.arr);
//        InitReferenceVariable initReferenceVariable = new InitReferenceVariable();
//        System.out.println(initReferenceVariable.obj);
    }
}
