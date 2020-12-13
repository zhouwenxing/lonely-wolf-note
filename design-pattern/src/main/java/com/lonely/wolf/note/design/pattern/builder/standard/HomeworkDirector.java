package com.lonely.wolf.note.design.pattern.builder.standard;

import com.alibaba.fastjson.JSONObject;
import com.lonely.wolf.note.design.pattern.builder.Homework;

/**
 * 建造者模式-调用者(Director)
 * @author zwx
 * @version 1.0
 * @date 2020/9/4
 * @since jdk1.8
 */
public class HomeworkDirector {
    public static void main(String[] args) {
        Homework homework = new Homework();
        HomeworkBuilder homeworkBuilder = new ConcreateBuilder(homework);
        homeworkBuilder.buildEasyQc("我是一道简单题目")
                .buildNormalQc("我是一道标准难度题目")
                .buildMediumQc("我是一道中等难度题目")
                .buildHardQc("我是一道高难度题目");
        homework = homeworkBuilder.build();
        System.out.println(JSONObject.toJSONString(homework));
    }
}
