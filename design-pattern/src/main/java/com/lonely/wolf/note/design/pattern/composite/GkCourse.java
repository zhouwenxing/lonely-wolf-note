package com.lonely.wolf.note.design.pattern.composite;

/**
 * 顶层抽象组件
 * @author zwx
 * @version 1.0
 * @date 2020/9/12
 * @since jdk1.8
 */
public abstract class GkCourse {
    public void addChild(GkCourse course){
        System.out.println("不支持添加操作");
    }

    public void removeChild(GkCourse course){
        System.out.println("不支持移除操作");
    }

    public void getName(GkCourse course){
        System.out.println("不支持获取名称操作");
    }

    public void info(GkCourse course){
        System.out.println("不支持查询信息操作");
    }
}
