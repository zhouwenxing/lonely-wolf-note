package com.lonely.wolf.note.initSort;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/28
 * @since jdk1.8
 */
public class InitReferenceVariable {
//    static ReferenceObj staticObj = new ReferenceObj();
//    ReferenceObj obj;
    static ReferenceObj[] arr = new ReferenceObj[10];//数组不会触发ReferenceObj的加载和初始化

//    static {
//        System.out.println("static code：" + staticObj);
//    }

//    public InitReferenceVariable() {
//        System.out.println("construct code：" + obj);
//    }
}
