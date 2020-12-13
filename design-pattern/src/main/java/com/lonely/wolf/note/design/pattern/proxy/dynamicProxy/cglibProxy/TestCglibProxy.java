package com.lonely.wolf.note.design.pattern.proxy.dynamicProxy.cglibProxy;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/11
 * @since jdk1.8
 */
public class TestCglibProxy {
    public static void main(String[] args){
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"G:\\");
        CglibTravelPerson cglibTravelPerson = (CglibTravelPerson) new CglibTravelAgency().getInstance(CglibTravelPerson.class);
        cglibTravelPerson.buyTrainTickey();
    }
}
