package com.lonely.wolf.note.exercise.easy.binarySearch;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 类似算法1，多出了 O(log n)的限制
 * 首次自解法
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/9/9
 * @since jdk1.8
 */
public class Algorithm3 {
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
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int middle = (high - low) / 2 + low;//这里如果采用加法（ (l+r)/2），数据过大会造成内存溢出
            int num = nums[middle];
            if (num == target){
                return middle;
            }
            //因为 low采用的是加法，high采用的是减法，所以不需要考虑数据越界，因为 low >high 会跳出循环
            if (num > target){
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        return high + 1;
    }
}
