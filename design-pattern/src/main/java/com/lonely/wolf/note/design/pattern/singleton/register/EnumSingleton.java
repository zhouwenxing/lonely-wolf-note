package com.lonely.wolf.note.design.pattern.singleton.register;

/**
 * 枚举式单例-推荐写法
 * @author zwx
 * @version 1.0
 * @date 2020/4/21
 * @since jdk1.8
 */
public enum EnumSingleton {
    INSTANCE;

    private MyObject myObject;

    EnumSingleton() {
        this.myObject = new MyObject();
    }

    public Object getData() {
        return myObject;
    }


    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

}
