package com.lonely.wolf.note.design.pattern.observe.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/25
 * @since jdk1.8
 */
public class GuavaEvent {

    @Subscribe
    public void subscribe(String str){
        System.out.println("进来了，收到的参数为【" +
                str + "】");
    }
}
