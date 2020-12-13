package com.lonely.wolf.note.design.pattern.singleton.register;

import java.lang.reflect.Constructor;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/21
 * @since jdk1.8
 */
public class TestEnumSingleton {

    public static void main(String[] args) throws Exception{

        //测试序列化是否可以破坏枚举式单例
//        EnumSingleton s1 = null;
//        EnumSingleton s2 = EnumSingleton.getInstance();
//
//        FileOutputStream fos = new FileOutputStream("EnumSingleton.text");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(s2);
//        oos.flush();
//        oos.close();
//
//        FileInputStream fis = new FileInputStream("EnumSingleton.text");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        s1 = (EnumSingleton)ois.readObject();
//        ois.close();
//        fis.close();
//        System.out.println(s1.getData() == s2.getData());//true

        //测试反射是否可以破坏枚举式单例
        Class clazz = EnumSingleton.class;
        Constructor c1 = clazz.getDeclaredConstructor();
        Constructor c2 = clazz.getDeclaredConstructor(String.class,int.class);
//        c2.setAccessible(true);
        System.out.println(c1.newInstance());
//        System.out.println(c2.newInstance("测试",666));

//        EnumSingleton enumSingleton = EnumSingleton.getInstance();
//        System.out.println(enumSingleton.getData() == enumSingleton.getData());


    }
}
