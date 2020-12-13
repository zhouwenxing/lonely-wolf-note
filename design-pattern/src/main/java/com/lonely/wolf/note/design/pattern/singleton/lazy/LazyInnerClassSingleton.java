package com.lonely.wolf.note.design.pattern.singleton.lazy;

import java.io.Serializable;

/**
 * 巧妙地利用内部类的特性实现单例写法
 * 虽然高大上，但是可以被反射攻击，也可以被序列化攻击
 * 内部类写法巧妙的利用了内部类的特性，LazyHolder里面的逻辑需要等到外面方法调用时才执行。
 * @author zwx
 * @version 1.0
 * @date 2020/4/20
 * @since jdk1.8
 */
public class LazyInnerClassSingleton implements Serializable {

    private LazyInnerClassSingleton(){
        //防止反射攻击
       if(null != LazyHolder.LAZY){
           throw new RuntimeException("不允许构造多个实例");
       }
    }
    private Object readResolve(){
        return LazyHolder.LAZY;
    }

    //LazyHolder里面的逻辑需要等到外面方法调用时才执行，巧妙的利用了内部类的特性
    //JVM底层执行逻辑，完美的避免了线程安全问题
    public static final LazyInnerClassSingleton getInstance(){
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}
