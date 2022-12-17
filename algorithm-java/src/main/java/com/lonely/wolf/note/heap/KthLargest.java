package com.lonely.wolf.note.heap;


import java.util.PriorityQueue;

/**
 * Leetcode 703：数据流中的第 K 大元素
 *
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest类：
 *  - KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 *  - int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 */
public class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int i=0;i<k;i++){
            pq.add(nums[i]);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
