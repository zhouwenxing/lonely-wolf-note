package com.lonely.wolf.note.design.pattern.singleton.threadlocal;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/21
 * @since jdk1.8
 */
public class TestThreadLocalSingleton {

    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread(()-> {
            ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + ":" + singleton);
        });
        t1.start();
    }
}
