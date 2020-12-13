package com.lonely.wolf.note.design.pattern.factory.abstractMethod;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/17
 * @since jdk1.8
 */
public class NorthFarmFactory implements IFactory {
    @Override
    public IApple createApple() {
        return new NorthApple();//北方农场生产北方苹果
    }

    @Override
    public IOrange createOrange() {
        return new NorthOrange();////北方农场生产北方桔子
    }
}
