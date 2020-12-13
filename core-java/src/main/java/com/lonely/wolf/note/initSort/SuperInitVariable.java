package com.lonely.wolf.note.initSort;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/28
 * @since jdk1.8
 */
public class SuperInitVariable {
    static String superStaticStr = "I'm Super Static Str1";
    String superInstanceStr = "I'm Super Instance Str1";
    static ReferenceObj referenceObj;

    static {
        superStaticStr = "I'm Super Static Str2";
        System.out.println("Super Static：" + superStaticStr);
    }

    public SuperInitVariable() {
        superInstanceStr = "I'm Super Instance Str2";
        System.out.println("Super Construct：" + superStaticStr);
    }
}
