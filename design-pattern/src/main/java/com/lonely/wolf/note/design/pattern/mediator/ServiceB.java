package com.lonely.wolf.note.design.pattern.mediator;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/1
 * @since jdk1.8
 */
public class ServiceB extends AbstractService {

    public ServiceB(AbstractMediator mediator) {
        super(mediator);
    }

    @Override
    public void doSomething() {
        System.out.println("I'm Service B");
    }

    public void callA(){
        this.doSomething();
        System.out.println("调用Service A");
        mediator.callServiceA();
    }
}
