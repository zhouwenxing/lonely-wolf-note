package com.lonely.wolf.note.design.pattern.observe.guava;

import com.google.common.eventbus.EventBus;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/25
 * @since jdk1.8
 */
public class GuavaEventTest {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("test");
    }
}
