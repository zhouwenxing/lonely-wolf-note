package com.lonely.wolf.note.design.pattern.singleton.seriable;

import java.io.Serializable;

/**
 *
 * @author zwx
 * @version 1.0
 * @date 2020/4/21
 * @since jdk1.8
 */
public class SeriableSingleton implements Serializable {

    public final static SeriableSingleton singleton = new SeriableSingleton();

    private SeriableSingleton(){

    }

    private Object readResolve(){
        return singleton;
    }

    public static SeriableSingleton getInstance(){
        return singleton;
    }

}
