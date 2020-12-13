package com.lonely.wolf.note.design.pattern.mediator.simple;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/1
 * @since jdk1.8
 */
public class Tenant {
    private HouseAgent houseAgent;

    public Tenant(HouseAgent houseAgent) {
        this.houseAgent = houseAgent;
    }


    public void queryHouseInfo(String address,String houseType){
        this.houseAgent.showInfo(address,houseType);
    }
}
