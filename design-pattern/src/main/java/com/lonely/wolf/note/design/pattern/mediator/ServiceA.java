package com.lonely.wolf.note.design.pattern.mediator;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/1
 * @since jdk1.8
 */
public class ServiceA extends AbstractService {

    public ServiceA(AbstractMediator mediator) {
        super(mediator);
    }

    @Override
    public void doSomething() {
        System.out.println("I'm Service A");
    }

    public void callB(){
        this.doSomething();
        System.out.println("调用Service B");
        mediator.callServiceB();
    }
}
