package com.lonely.wolf.note.design.pattern.proxy.staticProxy;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/11
 * @since jdk1.8
 */
public class TestStaticProxy {

    public static void main(String[] args) {
        TravelAgency travelAgency = new TravelAgency(new TravelPerson());
        travelAgency.buyTrainTickey();
    }
}
