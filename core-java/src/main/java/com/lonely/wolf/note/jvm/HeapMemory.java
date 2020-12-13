package com.lonely.wolf.note.jvm;

import org.openjdk.jol.info.ClassLayout;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/14
 * @since jdk1.8
 */
public class HeapMemory {
    public static void main(String[] args) {
//        Object obj = new Object();
        MyItem myItem = new MyItem();
        System.out.println(ClassLayout.parseInstance(myItem).toPrintable());
        SoftReference s;//软引用
        WeakReference ss;//弱引用
        PhantomReference sss;//虚引用
    }
}
