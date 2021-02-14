package com.lonely.wolf.note.redis;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/11/22
 * @since jdk1.8
 */
public class GuavaBloomFilter {
    private static final int expectedInsertions = 1000000;

    public static void main(String[] args) {
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),expectedInsertions);

        List<String> list = new ArrayList<>(expectedInsertions);

        for (int i = 0; i < expectedInsertions; i++) {
            String uuid = UUID.randomUUID().toString();
            bloomFilter.put(uuid);
            list.add(uuid);
        }

        int mightContainNum1 = 0;

        NumberFormat percentFormat =NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(2); //最大小数位数

        for (int i=0;i < 500;i++){
            String key = list.get(i);
            if (bloomFilter.mightContain(key)){
                mightContainNum1++;
            }
        }
        System.out.println("【key真实存在的情况】布隆过滤器认为存在的key值数：" + mightContainNum1);
        System.out.println("-----------------------分割线---------------------------------");

        int mightContainNum2 = 0;

        for (int i=0;i < expectedInsertions;i++){
            String key = UUID.randomUUID().toString();
            if (bloomFilter.mightContain(key)){
                mightContainNum2++;
            }
        }

        System.out.println("【key不存在的情况】布隆过滤器认为存在的key值数：" + mightContainNum2);
        System.out.println("【key不存在的情况】布隆过滤器的误判率为：" + percentFormat.format((float)mightContainNum2 / expectedInsertions));
    }
}
