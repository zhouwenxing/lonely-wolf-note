package com.lonely.wolf.note.design.pattern.templete;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/11
 * @since jdk1.8
 */
public abstract class CookingVegetables {

    protected final void cooking(){
        //1.放油
        this.putOil();
        //2.放入蔬菜
        this.putVegetables();
        //3.翻炒
        this.stirFry();
        //4.放点盐
        this.putSalt();
        //5.放入佐料，如果有些菜还需要放入其他如葱姜蒜之类的佐料的话就可以，如果没有就直接起锅了
        if (this.needSeasoning()){
            this.putSeasoning();
        }
        //6.起锅
        this.dishUp();

    }

    //放油
    final void putOil(){
        System.out.println("油下锅了。。。");
    }

    //放入蔬菜
    final void putVegetables(){
        System.out.println("菜下锅了。。。");
    }

    //翻炒
    final void stirFry(){
        System.out.println("正在翻炒。。。");
    }

    //放点盐
    final void putSalt(){
        System.out.println("放点盐。。。");
    }

    //放入其他佐料
    abstract void putSeasoning();

    //是否需要佐料，这个是钩子方法，用于流程微调
    protected boolean needSeasoning(){
        return true;
    }

    //起锅
    final void dishUp(){
        System.out.println("菜炒好了，可以起锅了");
    }



}
