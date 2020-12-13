package com.lonely.wolf.note.design.pattern.builder;

/**
 * 建造者模式-产品(Product)角色
 * 家庭作业
 * @author zwx
 * @version 1.0
 * @date 2020/9/4
 * @since jdk1.8
 */
public class Homework {
    private String easyQc;//简答题目

    private String normalQc;//正常题目

    private String MediumQc;//中等难度题目

    private String HardQc;//困难题目

    public String getEasyQc() {
        return easyQc;
    }

    public void setEasyQc(String easyQc) {
        this.easyQc = easyQc;
    }

    public String getNormalQc() {
        return normalQc;
    }

    public void setNormalQc(String normalQc) {
        this.normalQc = normalQc;
    }

    public String getMediumQc() {
        return MediumQc;
    }

    public void setMediumQc(String mediumQc) {
        MediumQc = mediumQc;
    }

    public String getHardQc() {
        return HardQc;
    }

    public void setHardQc(String hardQc) {
        HardQc = hardQc;
    }
}
