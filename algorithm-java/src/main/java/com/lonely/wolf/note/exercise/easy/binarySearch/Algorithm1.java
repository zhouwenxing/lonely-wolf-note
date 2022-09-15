package com.lonely.wolf.note.exercise.easy.binarySearch;

import java.util.Arrays;

/**
 * 给定一个n个元素有序的（升序）整型数组 nums 和一个目标值target，写一个函数搜索nums中的 target，
 * 如果目标值存在返回下标，否则返回 -1
 *
 * 首次自解法
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/9/7
 * @since jdk1.8
 */
public class Algorithm1 {
    static int index = 0;
    public static void main(String[] args) {
        int[] nums = {2,5};
        int target = 2;
        int result = search(nums,target);
        System.out.println(result);
    }


    public static int search(int[] nums, int target) {
        if (null == nums || nums.length == 0){
            return -1;
        }
        int length = nums.length;
        if (length == 1){
            if (nums[0] == target){
                return index;
            }
            return -1;
        }
        int middle = length / 2;
        if (nums[middle] == target){
            index = index + middle;
            return index;
        }
        if (nums[middle] < target){
            index = index + middle;
            return search(Arrays.copyOfRange(nums,middle,length),target);
        }
        return search(Arrays.copyOf(nums,middle),target);
    }
}
