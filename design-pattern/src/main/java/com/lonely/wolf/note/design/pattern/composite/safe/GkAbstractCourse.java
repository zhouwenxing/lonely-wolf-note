package com.lonely.wolf.note.design.pattern.composite.safe;

/**
 * 顶层抽象组件
 * @author zwx
 * @version 1.0
 * @date 2020/9/12
 * @since jdk1.8
 */
public abstract class GkAbstractCourse {
    protected String name;
    protected String score;

    public GkAbstractCourse(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public abstract void  info();
}
