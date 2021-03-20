package com.lonely.wolf.note.cocurrent;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/5/26
 * @since jdk1.8
 */
public class User {
    public User() {
    }

    public User(int age) {
        this.age = age;
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
