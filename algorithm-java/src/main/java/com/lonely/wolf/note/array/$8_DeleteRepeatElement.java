package com.lonely.wolf.note.array;

import java.util.Arrays;

/**
 * 删除有序数组中的重复项
 *
 * 给你⼀个有序数组 nums ，请你原地删除重复出现的元素，使每个元素只出现⼀次 ，返回删除后数组的新⻓度。
 * 要求1：不要使⽤额外的数组空间，你必须仅使⽤ O(1) 额外空间并原地修改输⼊数组。元素的顺序可以改变;
 * 要求2：不要使⽤额外的数组空间，你必须在原地修改输⼊数组 并在使⽤ O(1) 额外空间的条件下完成。
 *
 * 验证1：输⼊：nums = [1,1,2] 输出：2, nums = [1,2]
 * 验证2：输⼊：nums = [0,0,1,1,1,2,2,3,3,4] 输出：5, nums = [0,1,2,3,4]
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/20
 * @since jdk1.8
 */
public class $8_DeleteRepeatElement {
    public static void main(String[] args) {
        int[] arr = {1,1,2};
//        System.out.println(removeRepeatElement(arr));
        System.out.println(testRemoveRepeatElement(arr));
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeRepeatElement(arr2));
        System.out.println(Arrays.toString(arr2));

    }


    /**
     * 双指针法
     *
     * ⼀个指针负责责数组遍历，⼀个指向有效数组的最后⼀个位置,当两个指针的值不⼀样时，
     * 才将指向有效位的向后移动。
     *
     * @param arr - 数组
     * @return 返回剩余数组新长度
     */
    public static int removeRepeatElement(int[] arr) {
        if (null == arr || arr.length == 0){
            return -1;
        }

        int validLength = 1;//这里需要从1开始，否则下面的判断会有问题
        for (int i=0;i<arr.length;i++){
            if (arr[i] != arr[validLength - 1]){
                arr[validLength++] = arr[i];
            }
        }
        return validLength;
    }


    /**----------------------------------------------------以下为复盘练习使用方法---------------------------------------------*/

    public static int testRemoveRepeatElement(int[] arr) {
        if (null == arr || arr.length == 0){
            return 0;
        }
        int left=0,right=1;
        while (right < arr.length){
            if (arr[left] == arr[right]){
                right++;
            }else{
                arr[++left] = arr[right++];
            }
        }
        return left + 1;
    }
}
