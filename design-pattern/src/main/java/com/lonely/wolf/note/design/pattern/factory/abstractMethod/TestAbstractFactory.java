package com.lonely.wolf.note.design.pattern.factory.abstractMethod;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/11
 * @since jdk1.8
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        IFactory southFarmFactory = new SouthFarmFactory();
        IApple apple = southFarmFactory.createApple();
        apple.growApple();//输出：种植南方苹果

        IOrange orange = southFarmFactory.createOrange();
        orange.growOrange();//输出：种植南方桔子
    }
}
