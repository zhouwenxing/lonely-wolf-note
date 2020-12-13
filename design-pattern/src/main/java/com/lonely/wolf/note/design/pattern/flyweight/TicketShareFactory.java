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
public class TicketShareFactory {
    private static Map<String,IShareTicket> CACHE_POOL = new HashMap<>();

    public static IShareTicket getTicketInfo(String from,String to){
        String key = from + "->" + to;
        if (TicketShareFactory.CACHE_POOL.containsKey(key)){
            System.out.println("使用缓存");
            return TicketShareFactory.CACHE_POOL.get(key);
        }
        System.out.println("未使用缓存");
        IShareTicket ticket = new TrainShareTicket(from,to);
        CACHE_POOL.put(key,ticket);
        return ticket;
    }
}
