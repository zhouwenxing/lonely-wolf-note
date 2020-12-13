package com.lonely.wolf.note.jvm.overload;

import java.io.Serializable;

/**
 * 极端重载例子
 * 选择顺序：char-->int-->long-->float-->double-->Character-->Serializable-->Object-->chars
 * @author zwx
 * @version 1.0
 * @date 2020/8/12
 * @since jdk1.8
 */
public class OverloadDemo2 {

    public static void hello(Object a){
        System.out.println("Hello,Object");
    }
    public static void hello(double a){
        System.out.println("Hello,double");
    }
    public static void hello(Double a){
        System.out.println("Hello,Double");
    }
    public static void hello(float a){
        System.out.println("Hello,float");
    }
    public static void hello(long a){
        System.out.println("Hello,long");
    }
    public static void hello(int a){
        System.out.println("Hello,int");
    }
    public static void hello(Character a){
        System.out.println("Hello,Character");
    }
    public static void hello(char a){
        System.out.println("Hello,char");
    }
    public static void hello(char ...a){
        System.out.println("Hello,chars");
    }
    public static void hello(Serializable a){
        System.out.println("Hello,Serializable");
    }


    public static void main(String[] args) {
        OverloadDemo2.hello('1');

    }

}
