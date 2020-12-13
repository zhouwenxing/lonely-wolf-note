package com.lonely.wolf.note.genericity.array;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/8
 * @since jdk1.8
 */
public class TestArray {
    public static void main(String[] args) {
//        ArrElement<String>[] arr = new ArrElement<String>[10];//编译不通过
        ArrElement<String>[] arr = new ArrElement[10];//编译通过
//        ArrElement<String>[] arr2 = (ArrElement<String>[])new ArrElement<?>[10];

        //泛型擦除后会出现下面问题，所以禁止使用泛型初始化数组。
//        ArrElement[] arr = new ArrElement[10];

        Object[] objArr = arr;
        objArr[0] = new ArrElement<Integer>();
        System.out.println(objArr[0]);


    }
}
