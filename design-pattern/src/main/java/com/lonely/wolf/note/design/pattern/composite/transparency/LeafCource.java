package com.lonely.wolf.note.design.pattern.composite.transparency;

/**
 * 叶子节点
 * @author zwx
 * @version 1.0
 * @date 2020/9/12
 * @since jdk1.8
 */
public class LeafCource extends GkAbstractCourse {
    private String name;//课程名称
    private String score;//课程分数

    public LeafCource(String name, String score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void info() {
        System.out.println("课程:" + this.name + ",分数:" + score);
    }
}
