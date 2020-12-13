package com.lonely.wolf.note.jvm.oom;

/**
 * Java虚拟机栈-->StackOverflowError
 * @author zwx
 * @version 1.0
 * @date 2020/8/5
 * @since jdk1.8
 */
public class JMVStack {
    public static void main(String[] args) {
        test();
    }

    static void test(){
        test();
    }
}
