package com.lonely.wolf.note.design.pattern.builder.standard;

import com.lonely.wolf.note.design.pattern.builder.Homework;

/**
 * 建造者模式-抽象建造者(Builder)
 * @author zwx
 * @version 1.0
 * @date 2020/9/4
 * @since jdk1.8
 */
public abstract class HomeworkBuilder {
    public abstract HomeworkBuilder buildEasyQc(String easyQc);

    public abstract HomeworkBuilder buildNormalQc(String normalQc);

    public abstract HomeworkBuilder buildMediumQc(String mediumQc);

    public abstract HomeworkBuilder buildHardQc(String hardQc);

    public abstract Homework build();
}
