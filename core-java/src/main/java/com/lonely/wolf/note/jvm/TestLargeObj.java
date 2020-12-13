package com.lonely.wolf.note.jvm;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/26
 * @since jdk1.8
 */
public class TestLargeObj {
//    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) throws InterruptedException {
        byte[] bytes = new byte[1097152];//2097152
        System.gc();
    }
}
