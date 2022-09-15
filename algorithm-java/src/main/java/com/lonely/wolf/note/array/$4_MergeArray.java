package com.lonely.wolf.note.array;

import java.util.Arrays;

/**
 * 合并指定2个数组
 *
 * 给你两个按⾮递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数⽬。
 * 要求1：请你合并 nums2 到 nums1 中，使合并后的数组同样按 ⾮递减顺序 排列。
 * 要求2：合并后数组不应由函数返回，⽽是存储在数组 nums1 中。为了应对这种情况，nums1 的初始⻓度为 m+ n，
 * 其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的⻓度为 n
 *
 * 验证1：输⼊：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 输出：[1,2,2,3,5,6]
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/20
 * @since jdk1.8
 */
public class $4_MergeArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = new int[]{2, 5, 6};
//        mergeArray1(arr1,3,arr2,3);
//        mergeArray3(arr1,3,arr2,3);
//        System.out.println(Arrays.toString(arr1));

        int[] arr3 = {4,5,6,0,0,0};
        int[] arr4 = new int[]{1, 2, 3};
//        mergeArray4(arr1,3,arr2,3);
//        System.out.println(Arrays.toString(arr1));
//        mergeArray4(arr3,3,arr4,3);
        System.out.println(Arrays.toString(arr3));
    }


    /**
     * 合并两个数组，nums2合并到nums1
     * 直接合并，然后使用Arrays工具排序
     * @param nums1 - 合并数组
     * @param m - 合并数组长度
     * @param nums2 - 待合并数组
     * @param n - 待合并数组长度
     */
    public static void mergeArray1(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length < m + n){
            return;
        }
        for (int i=0;i<n;i++){
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }


    /**
     * 合并两个数组，nums2合并到nums1
     * 定义一个新数组来插入
     * @param nums1 - 合并数组
     * @param m - 合并数组长度
     * @param nums2 - 待合并数组
     * @param n - 待合并数组长度
     */
    public static void mergeArray2(int[] nums1, int m, int[] nums2, int n) {
        //TODO
    }


    /**
     * 合并两个数组，nums2合并到nums1
     * 比较合并，nums1从前往后会有数组移动问题，所以选择将nums1从后往前遍历合并
     * @param nums1 - 合并数组
     * @param m - 合并数组长度
     * @param nums2 - 待合并数组
     * @param n - 待合并数组长度
     */
    public static void mergeArray3(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length < m+n){
            return;
        }
        int mergeIndex = m+n-1,i= m-1,j=n-1;
        for (;i>=0;i--){
            for (;j>=0;j--){
                if (nums1[i] <= nums2[j]){
                    nums1[mergeIndex--] = nums2[j];
                    continue;
                }
                nums1[mergeIndex--] = nums1[i];
                break;
            }
            if (j < 0){//nums2循环结束，nums1剩余
                break;
            }
        }
        while (j>=0 && mergeIndex>=0){//nums1循环结束，nums2剩余
            nums1[mergeIndex--] = nums2[j--];
        }
    }


    /**
     * 合并两个数组，nums2合并到nums1
     * 比较合并，nums1从前往后会有数组移动问题，所以选择将nums1从后往前遍历合并
     * @param nums1 - 合并数组
     * @param m - 合并数组长度
     * @param nums2 - 待合并数组
     * @param n - 待合并数组长度
     */
    public static void mergeArray4(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length < m+n){
            return;
        }
        int mergeIndex = m+n-1,i= m-1,j=n-1;
        while (i>=0 && j>=0){
            nums1[mergeIndex--] = nums1[i] <= nums2[j]? nums2[j--]:nums1[i--];
        }
        //循环之后，假设nums1有剩余，不影响。nums2有剩余需要全部赋值过来
        while (j>=0){
            nums1[mergeIndex--] = nums2[j--];
        }
    }





    /**----------------------------------------------------以下为复盘练习使用方法---------------------------------------------*/


    public static void testMergeArray1(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0 || nums2.length == 0 || nums1.length < m+n){
            return;
        }
        int i = m+n-1;
        m--;
        n--;
        while (n >=0 && m >=0){
            if (nums1[m] > nums2[n]){
                nums1[i--] = nums1[m--];
            }else{
                nums1[i--] = nums2[n--];
            }
        }
        while (n >= 0){
            nums1[i--] = nums2[n--];
        }
    }
}
