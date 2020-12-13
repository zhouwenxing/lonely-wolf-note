package com.lonely.wolf.note.design.pattern.flyweight;

import java.math.BigDecimal;

/**
 * 具体享元角色(细粒度)
 * @author zwx
 * @version 1.0
 * @date 2020/9/12
 * @since jdk1.8
 */
public class TrainShareTicket implements IShareTicket {
    private String from;//内部状态
    private String to;//内部状态

    private String seatType = "站票";//外部状态

    public TrainShareTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void setSeat(String seatType){
        this.seatType = seatType;
    }

    @Override
    public void info() {
        System.out.println(from + "->" + to + ":" + seatType + this.getPrice(seatType));
    }

    private BigDecimal getPrice(String seatType){
        BigDecimal value = null;
        switch (seatType){
            case "硬座":
                value = new BigDecimal("100");
                break;
            case "硬卧":
                value = new BigDecimal("200");
                break;
            default:
                value = new BigDecimal("50");
        }
        return value;
    }
}
