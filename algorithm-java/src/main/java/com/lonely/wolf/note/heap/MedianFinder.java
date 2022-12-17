package com.lonely.wolf.note.heap;


import java.util.PriorityQueue;

/**
 * Leetcode：295.数据流的中位数
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如：
 * [2,3,4]的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 进阶:
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 *
 *
 * 方法一：利用两个堆来实现
 * 方法二：利用有序集合+双指针来实现
 *
 *
 */
public class MedianFinder {

    //小顶堆，存储较大元素，堆顶为较大元素的最小值
    private PriorityQueue<Integer> minHeap;

    //大顶堆，存储较小元素，堆顶为较小元素的最大值
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }

    public void addNum(int num) {
        if (minHeap.isEmpty() || num > minHeap.peek()){//当前数字大于 minHeap 中的最小元素，则放在小顶堆(存较大数据)
            minHeap.offer(num);
            if (minHeap.size() - maxHeap.size() > 1){
                maxHeap.offer(minHeap.poll());
            }
        }else {
            maxHeap.offer(num);
            if (maxHeap.size() > minHeap.size()){//确保多出的元素一定在小顶堆
                minHeap.offer(maxHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }
        return (minHeap.peek() + maxHeap.peek()) / 2;
    }
}
