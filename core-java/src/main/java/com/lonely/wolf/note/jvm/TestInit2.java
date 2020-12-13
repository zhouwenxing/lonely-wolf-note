package com.lonely.wolf.note.jvm;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/11
 * @since jdk1.8
 */
public class TestInit2 {
    public static void main(String[] args) {
        System.out.println(Sub_Class.value);
    }
}

class Sub_Class{
    public Sub_Class() {
        System.out.println("Sub_Class Construct");
    }
    static int value;
    static {
//        value = 20;
        System.out.println(value);//输出多少？
    }



}


