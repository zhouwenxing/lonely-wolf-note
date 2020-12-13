package com.lonely.wolf.note.design.pattern.singleton;

import com.lonely.wolf.note.design.pattern.singleton.threadlocal.ThreadLocalSingleton;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/20
 * @since jdk1.8
 */
public class ExectorThread3 implements Runnable{

    @Override
    public void run() {
        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
    }
}
