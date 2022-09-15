package com.lonely.wolf.note.exercise.easy.doublePointer;

/**
 * 977. 有序数组的平方
 * 给你一个按非递减顺序排序的整数数组 nums，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * 首次自解法：直接用冒泡排序，时间复杂度：O(logn)
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/9/10
 * @since jdk1.8
 */
public class Algorithm1 {

    public static void main(String[] args) {
        int nums[] = new int[]{-1};
        int nums2[] = sortedSquares(nums);
        System.out.println();
    }


    public static int[] sortedSquares(int[] nums) {
        boolean squareFlag = false;
        for (int i=0;i<nums.length;i++){
            if (!squareFlag){
                nums[i] = nums[i] * nums[i];
            }
            for (int j=i+1;j<nums.length;j++){
                if (!squareFlag){
                    nums[j] = nums[j] * nums[j];
                }
                if (nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
            squareFlag = true;
        }
        return nums;
    }
}
