package com.lonely.wolf.note.jvm;

/**
 * 两种优化方式：1、设置为Null 2、引入一个新的变量
 * @author zwx
 * @version 1.0
 * @date 2020/8/25
 * @since jdk1.8
 */
public class JVMTuningDemo {
    public static void main(String[] args) {
        {
            byte[] bytes = new byte[1024 * 1024 * 64];
            bytes = null;
        }
        int i = 0;
        System.gc();
    }
}
