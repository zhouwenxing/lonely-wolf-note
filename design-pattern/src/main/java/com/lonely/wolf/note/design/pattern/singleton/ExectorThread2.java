package com.lonely.wolf.note.design.pattern.singleton;

import com.lonely.wolf.note.design.pattern.singleton.lazy.LazyDoubleCheckSingleton;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/20
 * @since jdk1.8
 */
public class ExectorThread2 implements Runnable{

    @Override
    public void run() {
        LazyDoubleCheckSingleton lazySingleton = LazyDoubleCheckSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + lazySingleton);
    }
}
