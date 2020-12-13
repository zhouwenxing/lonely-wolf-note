package com.lonely.wolf.note.design.pattern.composite.safe;


/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/12
 * @since jdk1.8
 */
public class TestSafe {
    public static void main(String[] args) throws Exception {
        LeafCource ywCourse = new LeafCource("语文","150");
        LeafCource sxCourse = new LeafCource("数学","150");
        LeafCource yyCourse = new LeafCource("英语","150");

        LeafCource wlCourse = new LeafCource("物理","110");
        LeafCource hxCourse = new LeafCource("化学","100");
        LeafCource swCourse = new LeafCource("生物","90");

        BranchCource lzCourse = new BranchCource("理综","300",2);
        lzCourse.addChild(wlCourse);
        lzCourse.addChild(hxCourse);
        lzCourse.addChild(swCourse);

        BranchCource gkCourse = new BranchCource("理科高考","750",1);
        gkCourse.addChild(ywCourse);
        gkCourse.addChild(sxCourse);
        gkCourse.addChild(yyCourse);

        gkCourse.addChild(lzCourse);
        gkCourse.info();
    }
}
