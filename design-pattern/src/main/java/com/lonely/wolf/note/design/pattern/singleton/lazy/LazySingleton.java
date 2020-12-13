package com.lonely.wolf.note.design.pattern.singleton.lazy;

/**
 * 简单的饿汉式单例
 * @author zwx
 * @version 1.0
 * @date 2020/4/20
 * @since jdk1.8
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;

    private LazySingleton() {
    }

    public synchronized static LazySingleton getInstance(){
        if(null == lazySingleton){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

}
