package com.lonely.wolf.note.design.pattern.factory.abstractMethod;

/**
 * 南方工厂
 * @author zwx
 * @version 1.0
 * @date 2020/10/11
 * @since jdk1.8
 */
public class SouthFarmFactory implements IFactory {

    @Override
    public IApple createApple() {
        return new SouthApple();
    }

    @Override
    public IOrange createOrange() {
        return new SouthOrange();
    }
}
