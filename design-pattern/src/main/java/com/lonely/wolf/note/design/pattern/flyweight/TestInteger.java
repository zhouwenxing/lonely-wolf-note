package com.lonely.wolf.note.design.pattern.flyweight;

/**
 * Integer中的享元模式
 * @author zwx
 * @version 1.0
 * @date 2020/9/12
 * @since jdk1.8
 */
public class TestInteger {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(10);
        Integer b = 10;
        System.out.println(a==b);//true -128~127

        Integer m = Integer.valueOf(128);
        Integer n = 128;
        System.out.println(m==n);//false
    }
}
