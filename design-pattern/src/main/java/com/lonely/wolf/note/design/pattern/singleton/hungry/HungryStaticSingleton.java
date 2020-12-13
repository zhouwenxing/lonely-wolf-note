package com.lonely.wolf.note.design.pattern.singleton.hungry;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/20
 * @since jdk1.8
 */
public class HungryStaticSingleton {
    private static final HungryStaticSingleton hungrySigleton;

    static {
        hungrySigleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {
    }

    public static HungryStaticSingleton getInstance(){
        return hungrySigleton;
    }

}
