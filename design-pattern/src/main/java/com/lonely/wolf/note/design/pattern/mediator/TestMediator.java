package com.lonely.wolf.note.design.pattern.mediator;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/2
 * @since jdk1.8
 */
public class TestMediator {
    public static void main(String[] args) {
        AbstractMediator registerCenter = new RegisterCenter();
        ServiceA serviceA = new ServiceA(registerCenter);
        ServiceB serviceB = new ServiceB(registerCenter);

        registerCenter.setServiceA(serviceA);
        registerCenter.setServiceB(serviceB);

        serviceA.callB();
        System.out.println("--------------------");
        serviceB.callA();
    }
}
