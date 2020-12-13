package com.lonely.wolf.note.design.pattern.observe.headfirst;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/25
 * @since jdk1.8
 */
public interface Subject {
    void registerObserver(Observer o);//注册观察对象
    void removeObserver(Observer o);//移除观察对象
    void notifyObservers();//通知观察对象
}
