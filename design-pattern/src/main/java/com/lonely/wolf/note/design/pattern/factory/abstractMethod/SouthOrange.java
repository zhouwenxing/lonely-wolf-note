package com.lonely.wolf.note.design.pattern.factory.abstractMethod;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/11
 * @since jdk1.8
 */
public class SouthOrange implements IOrange {
    @Override
    public void growOrange() {
        System.out.println("种植南方桔子");
    }
}
