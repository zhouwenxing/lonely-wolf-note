package com.lonely.wolf.note.design.pattern.proxy.dynamicProxy.jdkProxy;

import com.lonely.wolf.note.design.pattern.proxy.Travel;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/11
 * @since jdk1.8
 */
public final class JdkTravelPerson implements Travel {
    @Override
    public void buyTrainTickey() {
        System.out.println("北京到上海");
        System.out.println("早上9:00出发");
    }
}
