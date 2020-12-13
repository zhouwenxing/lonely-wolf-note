package com.lonely.wolf.note.design.pattern.flyweight;

/**
 * 具体享元角色(粗粒度)
 * @author zwx
 * @version 1.0
 * @date 2020/9/12
 * @since jdk1.8
 */
public class TrainTicket implements ITicket{
    private String from;
    private String to;

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void info() {
        System.out.println(from + "->" + to + ":硬座：100元，硬卧：200元");
    }
}
