package com.lonely.wolf.note.design.pattern.builder.standard;

import com.lonely.wolf.note.design.pattern.builder.Homework;

/**
 * 建造者模式-具体建造者(ConcreteBuilder)
 * @author zwx
 * @version 1.0
 * @date 2020/9/4
 * @since jdk1.8
 */
public class ConcreateBuilder extends HomeworkBuilder {
    private Homework homework;

    public ConcreateBuilder(Homework homework) {
        this.homework = homework;
    }

    @Override
    public HomeworkBuilder buildEasyQc(String easyQc) {
        homework.setEasyQc(easyQc);
        return this;
    }

    @Override
    public HomeworkBuilder buildNormalQc(String normalQc) {
        homework.setNormalQc(normalQc);
        return this;
    }

    @Override
    public HomeworkBuilder buildMediumQc(String mediumQc) {
        homework.setMediumQc(mediumQc);
        return this;
    }

    @Override
    public HomeworkBuilder buildHardQc(String hardQc) {
        homework.setHardQc(hardQc);
        return this;
    }

    @Override
    public Homework build() {
        return homework;
    }

}
