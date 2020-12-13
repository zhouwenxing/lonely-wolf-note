package com.lonely.wolf.note.design.pattern.proxy.staticProxy;

import com.lonely.wolf.note.design.pattern.proxy.Travel;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/11
 * @since jdk1.8
 */
public class TravelAgency implements Travel {
    private TravelPerson travelPerson;

    public TravelAgency(TravelPerson travelPerson) {
        this.travelPerson = travelPerson;
    }

    @Override
    public void buyTrainTickey(){
        before();
        this.travelPerson.buyTrainTickey();
        after();

    }

    private void before() {
        System.out.println("付定金");
    }

    private void after() {
        System.out.println("付尾款");
    }
}
