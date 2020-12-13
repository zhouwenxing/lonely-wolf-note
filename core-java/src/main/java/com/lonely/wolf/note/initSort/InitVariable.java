package com.lonely.wolf.note.initSort;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/28
 * @since jdk1.8
 */
public class InitVariable {
    public static int m = 1;//静态变量(类变量)
    private int n = 2;//成员变量(实例变量)


    public static void main(String[] args) {
        System.out.println(InitVariable.m);//直接通过类访问变量
        InitVariable initVariable = new InitVariable();//创建一个实例对象
        System.out.println(initVariable.n);//需要通过实例对象才能访问成员变量
    }
}
