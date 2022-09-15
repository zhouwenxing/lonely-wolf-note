package com.lonely.wolf.note.exercise.easy.binarySearch;

/**
 * 给定一个n个元素有序的（升序）整型数组 nums 和一个目标值target，写一个函数搜索nums中的 target，
 * 如果目标值存在返回下标，否则返回 -1
 *
 * 力扣官方解法
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/9/8
 * @since jdk1.8
 */
public class Algorithm1_1 {

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
        return -1;
    }
}
