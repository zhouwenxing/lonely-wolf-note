package com.lonely.wolf.note.design.pattern.chainOfResponsibility.build;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/18
 * @since jdk1.8
 */
public class Builder1<T> {
    private BuildHandler1<T> head;
    private BuildHandler1<T> tail;

    public Builder1<T> addHanlder(BuildHandler1 handler){
        if (null == head){
            head = this.tail = handler;
            return this;
        }
        this.tail.next(handler);
        this.tail = handler;
        return this;
    }

    public BuildHandler1<T> build(){
        return this.head;
    }
}
