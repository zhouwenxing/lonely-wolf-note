package com.lonely.wolf.note.array;

import java.util.Arrays;

/**
 * 数组轮转问题
 *
 * 给你⼀个数组，将数组中的元素向右轮转 k 个位置，其中 k 是⾮负数。
 *
 * 验证1：输⼊: nums = [1,2,3,4,5,6,7], k = 3 输出: [5,6,7,1,2,3,4]
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/21
 * @since jdk1.8
 */
public class $10_RotateElement {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * ⾸先对整个数组实⾏翻转，这样⼦原数组中需要翻转的⼦数组，就会跑到数组最前⾯。
     * 然后从 k 处分隔数组，左右两数组，各⾃进⾏翻转即可
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        k %= nums.length;//需要考虑 k > nums.length 情况
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }


    public static void reverse(int[] nums, int start, int end) {
        while (start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
