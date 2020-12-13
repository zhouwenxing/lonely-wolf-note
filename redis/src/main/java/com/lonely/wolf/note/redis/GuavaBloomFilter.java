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


//        int rightNum1 = 0;
//        int wrongNum1 = 0;

        NumberFormat percentFormat =NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(2); //最大小数位数

//        for (int i=0;i < 500;i++){
//            String key = list.get(i);
//            if (bloomFilter.mightContain(key)){
//                if (list.contains(key)){
//                    rightNum1++;
//                }else {
//                    wrongNum1++;
//                }
//            }
//        }
//        System.out.println("布隆过滤器认为存在的key值数：" + rightNum1);
//        System.out.println("-----------------------分割线---------------------------------");

        int rightNum2 = 0;
        int wrongNum2 = 0;

        for (int i=0;i < 10000;i++){
            String key = UUID.randomUUID().toString();
            if (bloomFilter.mightContain(key)){
                if (list.contains(key)){
                    rightNum2++;
                }else {
                    wrongNum2++;
                }
            }
        }

        System.out.println("布隆过滤器认为存在的key值数：" + rightNum2);
        System.out.println("布隆过滤器认为不存在的key值数：" + wrongNum2);
        System.out.println("布隆过滤器的误判率为：" + percentFormat.format((float)wrongNum2 / 10000));
    }
}
