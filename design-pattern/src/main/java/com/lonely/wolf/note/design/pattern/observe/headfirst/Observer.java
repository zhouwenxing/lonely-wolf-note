package com.lonely.wolf.note.design.pattern.observe.headfirst;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/25
 * @since jdk1.8
 */
public interface Observer {
    void update(float temperature, float humidity, float pressure);//更新天气信息
}
