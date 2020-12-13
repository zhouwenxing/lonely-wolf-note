package com.lonely.wolf.note.cocurrent.atomic;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/19
 * @since jdk1.8
 */
public class TestAtomicReference {
    public static void main(String[] args) {
        User oldUser = new User(18,"张三");
        AtomicReference<User> atomicReference = new AtomicReference<>(oldUser);
        System.out.println("CAS前：" + JSONObject.toJSONString(atomicReference.get()));//{"age":18,"name":"张三"}

        User upateUser = new User(28,"李四");
        boolean result =atomicReference.compareAndSet(oldUser,upateUser);
        System.out.println("CAS结果为：" + result);//true
        System.out.println("CAS后：" + JSONObject.toJSONString(atomicReference.get()));//{"age":28,"name":"李四"}
    }
}

class User{
    volatile Integer age;
    private String name;

    public User(Integer age, String name) {
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
