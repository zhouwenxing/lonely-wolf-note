package com.lonely.wolf.note.cocurrent.atomic;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/19
 * @since jdk1.8
 */
public class TestAtomicReferenceMark {
    public static void main(String[] args) {
        Person person = new Person(18,"张三");
        AtomicMarkableReference atomicMarkableReference = new AtomicMarkableReference(person,false);
        System.out.println("是否被标记过：" + atomicMarkableReference.isMarked());

        System.out.println("CAS前：" + JSONObject.toJSONString(atomicMarkableReference.getReference()));//{"age":18,"name":"张三"}

        Person updatePerson = new Person(28,"李四");
        /**
         * arg1：表示预期的引用对象
         * arg2：表示即将更新的引用对象
         * arg3：表示预期的标记
         * arg4：表示更新的标记
         * 需要参数1和参数3都是预期值才会CAS成功
         */
        atomicMarkableReference.compareAndSet(person,updatePerson,false,true);
        System.out.println("CAS后：" + JSONObject.toJSONString(atomicMarkableReference.getReference()));//{"age":28,"name":"李四"}
    }
}

class Person{
    private Integer age;
    private String name;

    public Person(Integer age, String name) {
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
