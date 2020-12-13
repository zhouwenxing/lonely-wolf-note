package com.lonely.wolf.note.design.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元对象工厂
 * @author zwx
 * @version 1.0
 * @date 2020/9/12
 * @since jdk1.8
 */
public class TicketFactory {
    private static Map<String,ITicket> CACHE_POOL = new HashMap<>();

    public static ITicket getTicketInfo(String from,String to){
        String key = from + "->" + to;
        if (TicketFactory.CACHE_POOL.containsKey(key)){
            System.out.println("使用缓存");
            return TicketFactory.CACHE_POOL.get(key);
        }
        System.out.println("未使用缓存");
        ITicket ticket = new TrainTicket("深圳","广州");
        CACHE_POOL.put(key,ticket);
        return ticket;
    }
}
