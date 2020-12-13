package com.lonely.wolf.note.design.pattern.singleton;

import com.lonely.wolf.note.design.pattern.singleton.lazy.LazySingleton;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/20
 * @since jdk1.8
 */
public class ExectorThread implements Runnable{

    @Override
    public void run() {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + lazySingleton);
    }
}
