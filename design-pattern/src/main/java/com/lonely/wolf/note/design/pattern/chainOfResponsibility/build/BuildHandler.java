package com.lonely.wolf.note.design.pattern.chainOfResponsibility.build;

import com.lonely.wolf.note.design.pattern.chainOfResponsibility.LoginUser;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/2
 * @since jdk1.8
 */
public abstract class BuildHandler<T> {
    protected BuildHandler next;

    public void next(BuildHandler handler){
        this.next = handler;
    }

    public abstract void doHandler(LoginUser loginUser);

    public static class Builder<T>{
        private BuildHandler<T> head;
        private BuildHandler<T> tail;

        public Builder<T> addHanlder(BuildHandler handler){
            if (null == head){
                head = this.tail = handler;
                return this;
            }
            this.tail.next(handler);
            this.tail = handler;
            return this;
        }

        public BuildHandler<T> build(){
            return this.head;
        }
    }
}
