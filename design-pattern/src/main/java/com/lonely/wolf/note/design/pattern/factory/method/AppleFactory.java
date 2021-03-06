package com.lonely.wolf.note.design.pattern.factory.method;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/11
 * @since jdk1.8
 */
public class AppleFactory implements IFarmFactory {
    @Override
    public IProduct create() {
        return new Apple();
    }
}
