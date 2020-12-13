package com.lonely.wolf.note.design.pattern.factory.abstractMethod;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/17
 * @since jdk1.8
 */
public class NorthOrange implements IOrange {
    @Override
    public void growOrange() {
        System.out.println("种植北方桔子");
    }
}
