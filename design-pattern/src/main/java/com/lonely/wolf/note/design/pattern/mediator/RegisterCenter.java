package com.lonely.wolf.note.design.pattern.mediator;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/2
 * @since jdk1.8
 */
public class RegisterCenter extends AbstractMediator{
    @Override
    public void callServiceA() {
        super.serviceA.doSomething();

    }

    @Override
    public void callServiceB() {
        super.serviceB.doSomething();
    }
}
