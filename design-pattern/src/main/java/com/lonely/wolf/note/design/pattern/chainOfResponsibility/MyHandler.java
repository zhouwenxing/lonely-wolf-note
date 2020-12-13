package com.lonely.wolf.note.design.pattern.chainOfResponsibility;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/2
 * @since jdk1.8
 */
public abstract class MyHandler {
    protected MyHandler next;

    public void next(MyHandler handler){
        this.next = handler;
    }

    public abstract void doHandler(LoginUser loginUser);
}
