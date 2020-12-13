package com.lonely.wolf.note.design.pattern.mediator;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/2
 * @since jdk1.8
 */
public abstract class AbstractMediator {
    protected AbstractService serviceA;
    protected AbstractService serviceB;

    public void setServiceA(AbstractService serviceA) {
        this.serviceA = serviceA;
    }

    public void setServiceB(AbstractService serviceB) {
        this.serviceB = serviceB;
    }

    public abstract void callServiceA();

    public abstract void callServiceB();
}
