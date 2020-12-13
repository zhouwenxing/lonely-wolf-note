package com.lonely.wolf.note.design.pattern.composite.transparency;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/12
 * @since jdk1.8
 */
public class TestTransparency {
    public static void main(String[] args) throws Exception {
        GkAbstractCourse ywCourse = new LeafCource("语文","150");
        GkAbstractCourse sxCourse = new LeafCource("数学","150");
        GkAbstractCourse yyCourse = new LeafCource("英语","150");

        GkAbstractCourse wlCourse = new LeafCource("物理","110");
        GkAbstractCourse hxCourse = new LeafCource("化学","100");
        GkAbstractCourse swCourse = new LeafCource("生物","90");

        GkAbstractCourse lzCourse = new BranchCource("理综",2);
        lzCourse.addChild(wlCourse);
        lzCourse.addChild(hxCourse);
        lzCourse.addChild(swCourse);

        GkAbstractCourse gkCourse = new BranchCource("理科高考",1);
        gkCourse.addChild(ywCourse);
        gkCourse.addChild(sxCourse);
        gkCourse.addChild(yyCourse);

        gkCourse.addChild(lzCourse);
        gkCourse.info();
        swCourse.addChild(ywCourse);


    }
}
