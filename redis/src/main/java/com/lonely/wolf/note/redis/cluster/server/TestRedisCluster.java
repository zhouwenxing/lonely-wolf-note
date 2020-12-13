package com.lonely.wolf.note.redis.cluster.server;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/11/30
 * @since jdk1.8
 */
public class TestRedisCluster {
    public static void main(String[] args) throws IOException {
        HostAndPort hp1 = new HostAndPort("ip",6370);
        Set nodes = new HashSet<HostAndPort>();
        nodes.add(hp1);
        JedisCluster cluster = new JedisCluster(nodes);
        cluster.set("name", "lonely_wolf");
        System.out.println(cluster.get("name"));;
        cluster.close();
    }
}
