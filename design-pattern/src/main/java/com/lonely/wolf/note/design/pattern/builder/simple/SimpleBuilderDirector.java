package com.lonely.wolf.note.design.pattern.builder.simple;

import com.lonely.wolf.note.design.pattern.builder.Homework;

/**
 * 建造者模式-调用者(Director)
 * @author zwx
 * @version 1.0
 * @date 2020/9/4
 * @since jdk1.8
 */
public class SimpleBuilderDirector {
    public static void main(String[] args) {
        SimpleBuilder simpleBuilder = new SimpleBuilder(new Homework());
        simpleBuilder.buildEasyQc("简单题目");//1
        simpleBuilder.buildNormalQc("标准难度题目");//2
        simpleBuilder.buildMediumQc("中等难度题目");//3
        simpleBuilder.buildHardQc("高难度题目");//4
        Homework homework = simpleBuilder.build();

        StringBuilder sb = new StringBuilder();
        sb.append(null == homework.getEasyQc() ? "" : homework.getEasyQc() + ",");
        sb.append(null == homework.getNormalQc() ? "" : homework.getNormalQc() + ",");
        sb.append(null == homework.getMediumQc() ? "" : homework.getMediumQc() + ",");
        sb.append(null == homework.getHardQc() ? "" : homework.getHardQc());

        System.out.println("我的家庭作业有：" + sb.toString());
    }
}
