package com.lonely.wolf.note.design.pattern.singleton.threadlocal;

/**
 * ThreadLocal 不能保证其创建的对象是全局唯一，
 * 但是能保证在单个线程中是唯一的，天生的线程安全。
 *
 * @author zwx
 * @version 1.0
 * @date 2020/4/21
 * @since jdk1.8
 */
public class ThreadLocalSingleton {
    private ThreadLocalSingleton() {
    }

    private static final ThreadLocal<ThreadLocalSingleton> singleton =
            new ThreadLocal<ThreadLocalSingleton>() {
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    public static ThreadLocalSingleton getInstance(){
        return singleton.get();
    }
}
