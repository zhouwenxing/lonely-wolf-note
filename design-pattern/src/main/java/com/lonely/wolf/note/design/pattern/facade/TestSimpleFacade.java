package com.lonely.wolf.note.design.pattern.facade;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/20
 * @since jdk1.8
 */
public class TestSimpleFacade {
    public static void main(String[] args) {
        SimpleFacade simpleFacade = new SimpleFacade();
        simpleFacade.doA();
        simpleFacade.doB();
    }
}
