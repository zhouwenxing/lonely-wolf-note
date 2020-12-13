package com.lonely.wolf.note.design.pattern.singleton.hungry;

import java.io.Serializable;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/20
 * @since jdk1.8
 */
public class HungrySingleton implements Serializable {
    private static final HungrySingleton hungrySigleton = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance(){
        return hungrySigleton;
    }
}
