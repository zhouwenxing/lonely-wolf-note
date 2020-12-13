package com.lonely.wolf.note.redis.cluster.client;

import redis.clients.jedis.*;

import java.util.Arrays;
import java.util.List;

/**
 * Jedis客户端实现集群分片功能
 * @author zwx
 * @version 1.0
 * @date 2020/11/29
 * @since jdk1.8
 */
public class TestJedisSharding {
    public static void main(String[] args) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();

        //创建所有的连接服务分片
        JedisShardInfo shardInfo1 = new JedisShardInfo("ip", 6370);
        JedisShardInfo shardInfo2 = new JedisShardInfo("ip", 6371);

        //将所有连接加入连接池
        List<JedisShardInfo> shardInfoList = Arrays.asList(shardInfo1, shardInfo2);
        ShardedJedisPool jedisPool = new ShardedJedisPool(poolConfig, shardInfoList);

        //创建10个key值存入服务器
        ShardedJedis jedis = jedisPool.getResource();//获取连接
        for (int i=1;i<=10;i++){
            jedis.set("name" + i,"lonely_wolf" + i);
        }
        //取出key和其所在服务器信息
        for (int i=1;i<=10;i++){
            String key = "name" + i;
            Client client = jedis.getShard("name"+i).getClient();
            System.out.println("key值：" + jedis.get(key) + ",存在于服务器的端口为：" + client.getPort());
        }

    }
}
