package com.lonely.wolf.note.redis.sentinel;

import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/11/28
 * @since jdk1.8
 */
public class TestJedisSentinel {
    private static JedisSentinelPool pool;

    private static JedisSentinelPool initJedisSentinelPool() {
        // master的名字是sentinel.conf配置文件里面的名称
        String masterName = "mymaster";
        Set<String> sentinels = new HashSet<String>();
        sentinels.add("ip:26380");
//        sentinels.add("ip:26381");
//        sentinels.add("ip:26382");
        pool = new JedisSentinelPool(masterName, sentinels);
        return pool;
    }

    public static void main(String[] args) {
        JedisSentinelPool pool = initJedisSentinelPool();
        pool.getResource().set("name", "longly_wolf");
        System.out.println(pool.getResource().get("name"));
    }
}
