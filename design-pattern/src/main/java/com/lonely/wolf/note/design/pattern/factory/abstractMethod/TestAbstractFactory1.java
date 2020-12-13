package com.lonely.wolf.note.design.pattern.factory.abstractMethod;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/17
 * @since jdk1.8
 */
public class TestAbstractFactory1 {
    public static void main(String[] args) {
        IFactory northFarmFactory = new NorthFarmFactory();
        IApple apple = northFarmFactory.createApple();
        apple.growApple();//输出：种植北方苹果

        IOrange orange = northFarmFactory.createOrange();
        orange.growOrange();//输出：种植北方桔子
    }
}
