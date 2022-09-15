package com.lonely.wolf.note.array;

import java.util.Arrays;

/**
 * 原地移除所有数值等于 val 的元素
 *
 * 给你⼀个数组 nums 和⼀个值 val，你需要原地移除所有数值等于 val 的元素，并返回移除后数组的新⻓度。
 * 要求：不要使⽤额外的数组空间，你必须仅使⽤ O(1) 额外空间并原地修改输⼊数组。元素的顺序可以改变。
 * 你不需要考虑数组中超出新⻓度后⾯的元素。
 *
 * 验证1：输⼊：nums = [3,2,2,3], val = 3 输出：2, nums = [2,2]
 * 验证2：输⼊：nums = [0,1,2,2,3,0,4,2], val = 2 输出：5, nums = [0,1,4,0,3]
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/20
 * @since jdk1.8
 */
public class $7_DeleteElement {
    public static void main(String[] args) {
        int[] arr1 = {3,2,2,3,3};
        int[] arr2 = {0,1,2,2,3,0,4,2};
//        System.out.println(removeElement(arr1,3));
        System.out.println(testRemoveElement1(arr1,1));
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(removeElement(arr2,2));
//        System.out.println(Arrays.toString(arr2));
//
//        int[] arr3 = {3,2,2,3,3};
//        int[] arr4 = {0,1,2,2,3,0,4,2};
//        System.out.println(removeElement(arr3,3));
//        System.out.println(Arrays.toString(arr3));
//        System.out.println(removeElement(arr4,2));
//        System.out.println(Arrays.toString(arr4));

    }


    /**
     * 快慢双指针法
     *
     * 将数组分成前后两段，定义两个指针i和j，初始值都是0。i之前的位置都是有效部分，j表示当前要访问的元素。
     * 这样遍历的时候，j不断向后移动：
     * 如果array[j]的值不为val，则将其移动到array[++i]处。
     * 如果array[j]的值不为val，则将其移动到array[++i]处。
     * 这样，前半部分是有效部分，后半部分是⽆效部分
     * @param arr - 数组
     * @param val - 待移除元素
     * @return 返回剩余元素个数
     */
    public static int removeElement(int[] arr,int val) {
        if (null == arr || arr.length == 0){
            return -1;
        }

       int index = 0;//指针1
        for (int element : arr){//for循环有一个指针2
            if (element != val){
                arr[index++] = element;
            }
        }
        return index;
    }


    /**
     * 双指针交换移除（可能会打破原有排序方式）
     *
     * 从两端开始向中间遍历
     * left遇到num[i]=val的时候停下来，右侧则继续。
     * 当右侧遇到num[j]!=val的位置的时候，将num[j]交换或者直接覆盖num[i],之后i继续向右走
     * @param arr - 数组
     * @param val - 待移除元素
     * @return
     */
    public static int removeElement2(int[] arr,int val) {
        if (null == arr || arr.length == 0){
            return -1;
        }

        int right = arr.length - 1;
        for (int left=0;left<=right;){//注意这里left不能每次都加1，因为可能需要停下来
            if (arr[left] == val){//left停下，然后交换右边的值，继续比较一次
                arr[left] = arr[right--];
            }else{
                left++;
            }
        }
        return right + 1;
    }

    /**----------------------------------------------------以下为复盘练习使用方法---------------------------------------------*/

    public static int testRemoveElement1(int[] arr,int val) {
        if (null == arr || arr.length == 0){
            return 0;
        }
        int left = 0,right=arr.length-1;
        while (left <= right){
            if (arr[left] == val){
                arr[left] = arr[right--];
            }else {
                left++;
            }
        }
        return right + 1;
    }
}
