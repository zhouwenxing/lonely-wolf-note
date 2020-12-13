package com.lonely.wolf.note.cocurrent.atomic;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/19
 * @since jdk1.8
 */
public class TestAtomicReferenceArray {
    public static void main(String[] args) {
        Man man = new Man(18,"张三");
        Man[] arr = new Man[]{man};
        AtomicReferenceArray<Man> atomicReferenceArray = new AtomicReferenceArray<>(arr);
        System.out.println("CAS前：" + JSONObject.toJSONString(atomicReferenceArray.get(0)));//{"age":18,"name":"张三"}

        Man updateMan = new Man(28,"李四");
        atomicReferenceArray.compareAndSet(0,man,updateMan);
        System.out.println("CAS前：" + JSONObject.toJSONString(atomicReferenceArray.get(0)));//{"age":28,"name":"李四"}
    }
}

class Man{
    protected volatile Integer age;
    private String name;

    public Man(Integer age, String name) {
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
