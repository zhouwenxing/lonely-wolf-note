package com.lonely.wolf.note.heap;

import com.alibaba.fastjson.JSONObject;
import com.lonely.wolf.note.list.ListNode;

import java.util.*;

public class $1_Solution {

    public static void main(String[] args) {
        int[] nums = {19,87,25,43,70,8,117,117};
//        System.out.println(findKthLargest(nums,7));
//        System.out.println(JSONObject.toJSONString(maxSlidingWindow(nums,3)));
//        System.out.println(JSONObject.toJSONString(maxSlidingWindow2(nums,3)));

//        int[] nums1 = {1,1,2,3,3,3,3,2,2,2};
//        System.out.println(JSONObject.toJSONString(topKFrequentForNums(nums1,2)));
        String[] words = {"i","love","leetcode","i","love","coding"};
        System.out.println(JSONObject.toJSONString(topKFrequentForWords(words,1)));

    }


    /**
     * Leetcode 215：数组中的第K个最大元素
     *
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i=0;i<k;i++){
            minHeap.offer(nums[i]);
        }
        for (int i=k;i<nums.length;i++){
            Integer topEle = minHeap.peek();
            if (nums[i] > topEle){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }


    /**
     * Leetcode 23：合并K个升序链表
     *
     * 给你一个链表数组，每个链表都已经按升序排列，请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if(null == lists || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)->a.val-b.val);

        for (ListNode node : lists){
            if (null == node){
                continue;
            }
            heap.add(node);
        }

        ListNode sentryNode = new ListNode(-1);
        ListNode curr = sentryNode;
        while (!heap.isEmpty()){
            ListNode nextNode = heap.poll();
            curr.next = nextNode;
            curr = curr.next;
            if (null != nextNode.next){
                heap.add(nextNode.next);
            }
        }
        return sentryNode.next;
    }


    /**
     * Leetcode 239：滑动窗口最大值
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * @param k
     * @return 滑动窗口中的最大值 。
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (null == nums || nums.length == 0 || k <= 0){
            return null;
        }
        int size = nums.length <= k ? 1 : nums.length - k + 1;
        int[] largeArr = new int[size];
        PriorityQueue<Integer> heap = new PriorityQueue<>(k,(a,b) -> b-a);
        for (int i=0;i<k;i++){
            heap.add(nums[i]);
        }
        int index = 0;
        largeArr[index] = heap.peek();
        heap.remove(nums[index]);
        index++;

        for (int i=k;i<nums.length;i++){
            heap.add(nums[i]);
            largeArr[index] = heap.peek();
            heap.remove(nums[index]);//数据量过大会有性能问题，每次都可能会遍历所有数据
            index++;
        }
        return largeArr;
    }


    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (null == nums || nums.length == 0 || k <= 0){
            return null;
        }
        int size = nums.length <= k ? 1 : nums.length - k + 1;
        int[] largeArr = new int[size];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        for (int i=0;i<k;i++){
            heap.add(new int[]{nums[i],i});
        }
        int index = 0;
        largeArr[index++] = heap.peek()[0];

        for (int i=k;i<nums.length;i++){
            while (!heap.isEmpty() && heap.peek()[1] <= i-k){
                heap.poll();
            }
            heap.add(new int[]{nums[i],i});
            largeArr[index++] = heap.peek()[0];
        }
        return largeArr;
    }


    /**
     * Leetcode 347：前 K 个高频元素
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     * 进阶：你所设计算法的时间复杂度 必须 优于 O(nlog n) ，其中 n 是数组大小。
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequentForNums(int[] nums, int k) {
        if (null == nums || nums.length == 0 || k <= 0){
            return null;
        }
        Map<Integer,Integer> frequentMap = new HashMap<>();
        for (int num : nums){
            frequentMap.put(num,frequentMap.getOrDefault(num,0) + 1);
        }
        /**
         * 接下来有不同办法实现：
         * 1.排序（冒泡排序，复杂度：O(n2)）
         * 2.堆排序，复杂度：Ologx
         * 3.快排
         * 这里采用堆排序
         */
        PriorityQueue<int[]> heap = new PriorityQueue<>(k,(a,b)->a[1]-b[1]);

        Iterator<Map.Entry<Integer,Integer>> iterator = frequentMap.entrySet().iterator();
        int i=0;
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            if (i > k-1){
                if (heap.peek()[1] < entry.getValue()){
                    heap.poll();
                    heap.add(new int[]{entry.getKey(),entry.getValue()});
                }
            }else{
                heap.add(new int[]{entry.getKey(),entry.getValue()});
            }
            i++;
        }

        int[] res = new int[k];
        while (!heap.isEmpty()){
            res[--k] = heap.poll()[0];
        }
        return res;
    }


    /**
     * Leetcode 692：前K个高频单词
     * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
     *
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序排序。
     *
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequentForWords(String[] words, int k) {
        if (null == words || words.length == 0 || k <= 0){
            return null;
        }
        Map<String,Integer> frequentMap = new HashMap<>();
        for (String word : words){
            frequentMap.put(word,frequentMap.getOrDefault(word,0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>(k,(s1,s2) -> {
            if (frequentMap.get(s1) == frequentMap.get(s2)){
                return s2.compareTo(s1);
            }else {
                return frequentMap.get(s1) - frequentMap.get(s2);
            }
        });
        Iterator<Map.Entry<String,Integer>> iterator = frequentMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> entry = iterator.next();
            heap.add(entry.getKey());
            if (heap.size() > k){
                heap.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!heap.isEmpty()){
            res.add(heap.poll());
        }
        return res;
    }

    /**
     * Leetcode 692：前K个高频单词
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequentForWordsNoHeap(String[] words, int k) {
        if (null == words || words.length == 0 || k <= 0){
            return null;
        }
        Map<String,Integer> frequentMap = new HashMap<>();
        for (String word : words){
            frequentMap.put(word,frequentMap.getOrDefault(word,0) + 1);
        }

        List<String> resList = new ArrayList<>(frequentMap.keySet());
        resList.sort((s1,s2)->{
            if (frequentMap.get(s1) == frequentMap.get(s2)){
                return s1.compareTo(s2);
            }else {
                return frequentMap.get(s2) - frequentMap.get(s1);
            }
        });
        return resList.subList(0,k);
    }

}
