package com.lonely.wolf.note.design.pattern.composite.safe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/12
 * @since jdk1.8
 */
public class BranchCource extends GkAbstractCourse{
    private List<GkAbstractCourse> courseList = new ArrayList<>();
    private int level;

    public BranchCource(String name, String score, int level) {
        super(name,score);
        this.level = level;
    }

    public void addChild(GkAbstractCourse course) {
        courseList.add(course);
    }

    @Override
    public void info() {
       System.out.println("课程:" + this.name + ",分数：" + this.score);
       for (GkAbstractCourse course : courseList){
           for (int i=0;i<level;i++){
               System.out.print("  ");
           }
           System.out.print(">");
           course.info();
       }
    }
}
