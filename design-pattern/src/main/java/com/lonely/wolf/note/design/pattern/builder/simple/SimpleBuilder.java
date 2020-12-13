package com.lonely.wolf.note.design.pattern.builder.simple;

import com.lonely.wolf.note.design.pattern.builder.Homework;

/**
 * 建造者模式-具体建造者(ConcreteBuilder)
 * @author zwx
 * @version 1.0
 * @date 2020/9/4
 * @since jdk1.8
 */
public class SimpleBuilder {
    private Homework homework;

    public SimpleBuilder(Homework homework) {
        this.homework = homework;
    }

    public void buildEasyQc(String easyQc){
        homework.setEasyQc(easyQc);
    }

    public void buildNormalQc(String normalQc){
        homework.setNormalQc(normalQc);
    }

    public void buildMediumQc(String mediumQc){
        homework.setMediumQc(mediumQc);
    }

    public void buildHardQc(String hardQc){
        homework.setHardQc(hardQc);
    }

    public Homework build(){
        return homework;
    }
}
