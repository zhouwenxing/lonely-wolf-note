package com.lonely.wolf.note.design.pattern.singleton.lazy;


/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/20
 * @since jdk1.8
 */
public class LazyInnerClassSingletonTest {

    public static void main(String[] args) throws Exception {
        //反射攻击内部类式单例
//        Class<?> clazz = LazyInnerClassSingleton.class;
//        Constructor constructor = clazz.getDeclaredConstructor(null);
//        constructor.setAccessible(true);
//        Object o1 = constructor.newInstance();
//        Object o2 = LazyInnerClassSingleton.getInstance();
//
//        System.out.println(o1 == o2);
    }
}
