package com.lonely.wolf.note.redis.bloom;

import orestes.bloomfilter.FilterBuilder;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/11/28
 * @since jdk1.8
 */
public class CountingBloomFilter {
    public static void main(String[] args) {
        orestes.bloomfilter.CountingBloomFilter<String> cbf = new FilterBuilder(10000,
                0.01).countingBits(8).buildCountingBloomFilter();

        cbf.add("zhangsan");
        cbf.add("lisi");
        cbf.add("wangwu");
        System.out.println("是否存在王五：" + cbf.contains("wangwu")); //true
        cbf.remove("wangwu");
        System.out.println("是否存在王五：" + cbf.contains("wangwu")); //false

        System.out.println(Integer.toBinaryString(16).length());

    }
}
