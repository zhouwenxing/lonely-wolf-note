package com.lonely.wolf.note.jvm;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/10
 * @since jdk1.8
 */
public class TestInit1 {
    public static void main(String[] args) {
//        System.out.println(new SubClass());//先初始化父类，后初始化子类
//        System.out.println(SubClass.value);//只初始化父类，因为对于static字段，只会初始化字段所在类
//        System.out.println(SubClass.finalValue);//不会初始化任何类，final修饰的数据初始化之前就会放到常量池
//        System.out.println(SubClass.s1);//不会初始化任何类，final修饰的数据初始化之前就会放到常量池
//        SubClass[] arr = new SubClass[5];//数组不会触发初始化
    }

}


class SuperClass{
  static {
        System.out.println("Init SuperClass");
    }
    static int value = 100;

    final static int finalValue = 200;

    final static String s1 = "Hello JVM";
}

class SubClass extends SuperClass {
    static {
        System.out.println("Init SubClass");
    }
}
