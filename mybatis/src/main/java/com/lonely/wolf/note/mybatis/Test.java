package com.lonely.wolf.note.mybatis;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/10
 * @since jdk1.8
 */
public class Test {

    public static void main(String[] args) {
        String className = "helloWorld";
        String firstLetter = className.substring(0,1);
        System.out.println(firstLetter.toLowerCase() + className.substring(1));
    }
}
