package com.lonely.wolf.note.initSort;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/28
 * @since jdk1.8
 */
public class ReferenceObj {
    static String referenceStaticStr;
    String referenceInstanceStr;

    static {
        referenceStaticStr = "I'm reference Static Str";
        System.out.println(referenceStaticStr);
    }

    public ReferenceObj() {
        referenceInstanceStr = "I'm reference Construct Str";
        System.out.println(referenceInstanceStr);
    }
}
