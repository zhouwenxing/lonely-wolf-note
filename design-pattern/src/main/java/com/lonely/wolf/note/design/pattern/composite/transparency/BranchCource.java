package com.lonely.wolf.note.design.pattern.composite.transparency;

import java.util.ArrayList;
import java.util.List;

/**
 * 树枝节点
 * @author zwx
 * @version 1.0
 * @date 2020/9/12
 * @since jdk1.8
 */
public class BranchCource extends GkAbstractCourse{
    private List<GkAbstractCourse> courseList = new ArrayList<>();
    private String name;//科目名称
    private int level;//层级

    public BranchCource(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void addChild(GkAbstractCourse course) {
        courseList.add(course);
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void info() throws Exception {
       System.out.println("课程:" + this.name);
       for (GkAbstractCourse course : courseList){
           for (int i=0;i<level;i++){
               System.out.print("  ");
           }
           System.out.print(">");
           course.info();
       }
    }
}
