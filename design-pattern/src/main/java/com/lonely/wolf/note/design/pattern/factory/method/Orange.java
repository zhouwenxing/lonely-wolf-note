package com.lonely.wolf.note.design.pattern.factory.method;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/10
 * @since jdk1.8
 */
public class Orange implements IProduct {
    @Override
    public void grow() {
        System.out.println("种植桔子");
    }
}
