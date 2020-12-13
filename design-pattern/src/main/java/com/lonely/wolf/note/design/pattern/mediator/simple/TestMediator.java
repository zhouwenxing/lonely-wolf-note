package com.lonely.wolf.note.design.pattern.mediator.simple;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/1
 * @since jdk1.8
 */
public class TestMediator {
    public static void main(String[] args) {
        HouseAgent houseAgent = new HouseAgent();

        Tenant tenant = new Tenant(houseAgent);
        tenant.queryHouseInfo("xxx小区xxx栋","一房一厅");
    }
}
