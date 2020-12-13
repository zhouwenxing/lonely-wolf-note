package com.lonely.wolf.note.design.pattern.mediator;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/2
 * @since jdk1.8
 */
public abstract class AbstractService {
    protected AbstractMediator mediator;

    public AbstractService(AbstractMediator mediator) {
        this.mediator = mediator;
    }

    public abstract void doSomething();
}
