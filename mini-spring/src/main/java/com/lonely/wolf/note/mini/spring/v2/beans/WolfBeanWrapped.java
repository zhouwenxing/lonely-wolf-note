package com.lonely.wolf.note.mini.spring.v2.beans;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/2/11
 * @since jdk1.8
 */
public class WolfBeanWrapped {
    private Object wrappedInstance;

    public WolfBeanWrapped() {
    }

    public WolfBeanWrapped(Object wrappedInstance) {
        this.wrappedInstance = wrappedInstance;
    }

    public Object getWrappedInstance(){
        return this.wrappedInstance;
    }


    public Class<?> getWrappedClass(){
        return this.wrappedInstance.getClass();
    }
}
