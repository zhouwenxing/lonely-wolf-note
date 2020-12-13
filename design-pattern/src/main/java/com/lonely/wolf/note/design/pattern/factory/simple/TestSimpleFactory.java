package com.lonely.wolf.note.design.pattern.factory.simple;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/10
 * @since jdk1.8
 */
public class TestSimpleFactory {
    public static void main(String[] args) throws Exception {
        SimpleFactory factory = new SimpleFactory();
//        IProduct apple = factory.createProduct("apple");
//        apple.grow();//输出：种植苹果
//
//        IProduct orange = factory.createProduct("orange");
//        orange.grow();//输出：种植桔子

        IProduct apple = factory.createProduct2(Apple.class);
        apple.grow();//输出：种植苹果

        IProduct orange = factory.createProduct2(Orange.class);
        orange.grow();//输出：种植桔子
    }
}
