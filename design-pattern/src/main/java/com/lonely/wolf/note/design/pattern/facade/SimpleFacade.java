package com.lonely.wolf.note.design.pattern.facade;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/20
 * @since jdk1.8
 */
public class SimpleFacade {
    private SubSystemA systemA = new SubSystemA();
    private SubSystemB systemB = new SubSystemB();


    public void doA(){
        this.systemA.doSomething();
    }
    public void doB(){
        this.systemB.doSomething();
    }
}
