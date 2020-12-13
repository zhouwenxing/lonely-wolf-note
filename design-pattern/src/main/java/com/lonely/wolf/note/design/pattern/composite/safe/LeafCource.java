package com.lonely.wolf.note.design.pattern.composite.safe;

/**
 * 叶子节点
 * @author zwx
 * @version 1.0
 * @date 2020/9/12
 * @since jdk1.8
 */
public class LeafCource extends GkAbstractCourse {

    public LeafCource(String name, String score) {
        super(name,score);
    }

    @Override
    public void info() {
        System.out.println("课程:" + this.name + ",分数:" + this.score);
    }
}
