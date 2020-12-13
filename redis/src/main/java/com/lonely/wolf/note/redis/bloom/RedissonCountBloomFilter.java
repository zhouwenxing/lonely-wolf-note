package com.lonely.wolf.note.redis.bloom;

import org.redisson.RedissonExtend;
import org.redisson.api.RCountingBloomFilter;
import org.redisson.api.RedissonClientExtend;
import org.redisson.config.Config;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/11/24
 * @since jdk1.8
 */
public class RedissonCountBloomFilter {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        RedissonClientExtend redissonClientExtend = RedissonExtend.create(config);

        RCountingBloomFilter<String> bloomFilter = redissonClientExtend.getCountingBloomFilter("test_bloom_filter", 100);//3表示可重复次数

        //TODO 报错，有时间研究
//        bloomFilter.tryInit(10000, 0.03);
//        bloomFilter.tryInit(10000, 0.0001D);

        bloomFilter.add("test1");

        if (bloomFilter.contains("test1")){
            System.out.println("存在");
        }
        bloomFilter.remove("test1");

        if (bloomFilter.contains("test1")){
            System.out.println("存在");
        }
//        bloomFilter.delete();

    }
}
