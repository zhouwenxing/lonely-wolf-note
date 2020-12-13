package com.lonely.wolf.note.design.pattern.singleton.lazy;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/17
 * @since jdk1.8
 */
public class LazySyncSingleton {
    private static LazySyncSingleton lazySingleton = null;

    private LazySyncSingleton() {
    }

    public synchronized static LazySyncSingleton getInstance(){
        if(null == lazySingleton){
            lazySingleton = new LazySyncSingleton();
        }
        return lazySingleton;
    }
}
