package com.lonely.wolf.note.design.pattern.factory.abstractMethod;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/17
 * @since jdk1.8
 */
public class NorthApple implements IApple {
    @Override
    public void growApple() {
        System.out.println("种植北方苹果");
    }
}
