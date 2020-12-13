package com.lonely.wolf.note.design.pattern.singleton.lazy;

/**
 * Double Check Lock
 * @author zwx
 * @version 1.0
 * @date 2020/4/20
 * @since jdk1.8
 */
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton lazySingleton = null;

    private LazyDoubleCheckSingleton() {
    }

    public static LazyDoubleCheckSingleton getInstance(){
        if(null == lazySingleton){
            synchronized (LazyDoubleCheckSingleton.class){
                if(null == lazySingleton){
                    /**
                     * 1.分配内存给对象
                     * 2.初始化对象
                     * 3.将初始化好的对象和内存地址建立关联(赋值)
                     * 4.用户初次访问
                     * 为了防止指令重排序引起的DCL失效，需要使用volatile关键字
                     */
                    lazySingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazySingleton;
    }
}
