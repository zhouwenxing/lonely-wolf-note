package com.lonely.wolf.note.jvm;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/11
 * @since jdk1.8
 */
public class JVMDemo {

    public static void main(String[] args) {
        int sum = add(null, 20);
        print(sum);
    }

    public static int add(int[] a, int b) {
        a=new int[]{1,2,3,4,5};
        int result = a[0] + b;
        return result;
    }

    public static void print(int num) {
        System.out.println(num);
    }
}
