package com.lonely.wolf.note.design.pattern.facade;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/20
 * @since jdk1.8
 */
public class Facade {
    private SubSystemA systemA = new SubSystemA();
    private SubSystemB systemB = new SubSystemB();

    public void doAB(){
        this.systemA.doSomething();
        this.systemB.doSomething();
    }
}
