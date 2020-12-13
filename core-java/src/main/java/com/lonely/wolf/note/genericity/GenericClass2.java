package com.lonely.wolf.note.genericity;

/**
 * 泛型类
 * @author zwx
 * @version 1.0
 * @date 2020/10/8
 * @since jdk1.8
 */
public class GenericClass2<T extends MyItem,Serializable,Cloneable>{
    public static void main(String[] args) {
        GenericClass2 genericClass2 = new GenericClass2<MyItemSub,Integer,MyItemSub>();
    }
}
