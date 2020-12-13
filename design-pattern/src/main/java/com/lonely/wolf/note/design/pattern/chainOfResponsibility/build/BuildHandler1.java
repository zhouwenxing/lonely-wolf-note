package com.lonely.wolf.note.design.pattern.chainOfResponsibility.build;

import com.lonely.wolf.note.design.pattern.chainOfResponsibility.LoginUser;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/18
 * @since jdk1.8
 */
public abstract class BuildHandler1<T>{
    protected BuildHandler1 next;

    public void next(BuildHandler1 handler){
        this.next = handler;
    }

    public abstract void doHandler(LoginUser loginUser);

}
