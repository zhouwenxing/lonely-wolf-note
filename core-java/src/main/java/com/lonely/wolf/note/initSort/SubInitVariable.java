package com.lonely.wolf.note.initSort;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/28
 * @since jdk1.8
 */
public class SubInitVariable extends SuperInitVariable {
    static String subStaticStr = "I'm Sub Static Str1";
    String subInstanceStr = "I'm Sub Instance Str1";


    static {
        subStaticStr = "I'm Sub Static Str2";
        System.out.println("Sub Static：" + subStaticStr);
    }

    public SubInitVariable() {
        subInstanceStr = "I'm Sub Instance Str1";
        System.out.println("Sub Instance：" + subInstanceStr);
    }
}
