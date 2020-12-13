package com.lonely.wolf.note.design.pattern.singleton.register;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/21
 * @since jdk1.8
 */
public class TestContainerSingleton2 {
    public static void main(String[] args) {
        MyObject myObject1 = (MyObject) ContainerSingleton.getBean("com.zwx.design.pattern.singleton.register.MyObject");
        MyObject myObject2 = (MyObject) ContainerSingleton.getBean("com.zwx.design.pattern.singleton.register.MyObject");

        System.out.println(myObject1 == myObject2);
    }
}
