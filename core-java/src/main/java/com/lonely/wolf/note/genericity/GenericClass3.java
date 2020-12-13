package com.lonely.wolf.note.genericity;

/**
 * 泛型类
 * @author zwx
 * @version 1.0
 * @date 2020/10/8
 * @since jdk1.8
 */
public class GenericClass3<T extends MyItem>{

    public static void main(String[] args) {
        MyItemSub myItemSub = new MyItemSub();
        MyItem myItem = myItemSub;//编译通过

//        GenericClass3<MyItemSub> myItemSubGenericClass = new GenericClass3<>();
//        GenericClass3<MyItem> myItemGenericClass = myItemSubGenericClass;//编译失败
    }




}
