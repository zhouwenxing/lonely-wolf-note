package com.lonely.wolf.note.design.principle.lod;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/7
 * @since jdk1.8
 */
public class Manager {
    private Cabbage cabbage;

    public Manager(Cabbage cabbage) {
        this.cabbage = cabbage;
    }

    public void getCabbageSaleMoney(){
        cabbage.saleRecord();
    }
}
