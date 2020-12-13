package com.lonely.wolf.note.design.pattern.flyweight;

/**
 * 抽象享元角色
 * @author zwx
 * @version 1.0
 * @date 2020/9/12
 * @since jdk1.8
 */
public interface IShareTicket {
    void info();

    void setSeat(String seatType);
}
