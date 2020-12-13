package com.lonely.wolf.note.design.pattern.flyweight;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/12
 * @since jdk1.8
 */
public class TestTicket {

    public static void main(String[] args) {
        ITicket ticket = TicketFactory.getTicketInfo("深圳","广州");
        ticket.info();//首次创建对象
        ticket = TicketFactory.getTicketInfo("深圳","广州");
        ticket.info();//使用缓存
        ticket = TicketFactory.getTicketInfo("深圳","北京");
        ticket.info();//换了目的地，无法使用缓存
    }
}
