package com.lonely.wolf.note.design.pattern.iterator;

/**
 * 遍历元素-行李
 * @author zwx
 * @version 1.0
 * @date 2020/10/2
 * @since jdk1.8
 */
public class Baggage {
    private String name;

    public Baggage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
