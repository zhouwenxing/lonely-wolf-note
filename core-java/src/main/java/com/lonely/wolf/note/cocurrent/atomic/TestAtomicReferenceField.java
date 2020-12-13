package com.lonely.wolf.note.cocurrent.atomic;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/19
 * @since jdk1.8
 */
public class TestAtomicReferenceField {
    public static void main(String[] args) {
        //AtomicIntegerFieldUpdater
//        Women women = new Women(18,"张三");
//        //arg1：引用的对象类型 arg2：要修改的对象中的属性名
//        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Women.class,"age");
//        atomicIntegerFieldUpdater.compareAndSet(women,18,28);
//        System.out.println("CAS后的值：" + women.getAge());//28


        //AtomicReferenceFieldUpdater
        /**
         * arg1:传入引用对象类型
         * arg2：传入引用对象的属性类型
         * arg3：传入要修改的属性名
         */
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = AtomicReferenceFieldUpdater.newUpdater(Women.class,Integer.class,"age");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = AtomicReferenceFieldUpdater.newUpdater(Women.class,String.class,"name");

        Women women = new Women(18,"张三");
        atomicReferenceFieldUpdater1.compareAndSet(women,18,28);
        atomicReferenceFieldUpdater2.compareAndSet(women,"张三","李四");
        System.out.println(JSONObject.toJSONString(women));//{"age":28,"name":"李四"}
    }
}

class Women{
    volatile Integer age;
    volatile String name;

    public Women(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
