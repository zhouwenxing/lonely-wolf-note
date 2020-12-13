package com.lonely.wolf.note.design.pattern.factory.method;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/11
 * @since jdk1.8
 */
public class TestFactoryMethod {
    public static void main(String[] args) {
        IFarmFactory appleFactory = new AppleFactory();
        IProduct apple = appleFactory.create();
        apple.grow();//输出：种植苹果

        IFarmFactory orangeFactory = new OrangeFactory();
        IProduct orange = orangeFactory.create();
        orange.grow();//输出：种植桔子
    }
}
