package com.lonely.wolf.note.array;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 *
 * 合并 N 个长度为 L 的有序数组
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/20
 * @since jdk1.8
 */
public class $5_MergeNArray {
    public static void main(String[] args) {

        int[] arr1 = {1, 3, 5, 6};
        int[] arr2 = {1, 2, 5, 7};
        int[] arr3 = {3, 6, 9, 11};
        int[] arr4 = {5, 7, 13, 17};

        //先合并到一起再排序
        int[][] twoArray2 = new int[4][4];
        twoArray2[0] = Arrays.copyOf(arr1, 4);
        twoArray2[1] = Arrays.copyOf(arr2, 4);
        twoArray2[2] = Arrays.copyOf(arr3, 4);
        twoArray2[3] = Arrays.copyOf(arr4, 4);
        System.out.println(Arrays.deepToString(twoArray2));//合并成二维数组
        System.out.println(twoArray2.length);

        System.out.println(JSONObject.toJSONString(mergeNArrays1(twoArray2)));
        System.out.println(JSONObject.toJSONString(mergeNArrays2(twoArray2)));

    }


    /**
     * 先合并到同一个数组，然后排序
     * @param array
     * @return
     */
    public static int[] mergeNArrays1(int[][] array) {
        int N = array.length, L;
        if (N == 0) {
            return new int[0];
        }

        //数组内容校验
        L = array[0].length;
        for (int i = 1; i < N; i++){
            if (L != array[i].length){
                return new int[0];
            }
        }

        int[] result = new int[N * L];//定义新数组
        for (int i = 0; i < N; i++){//依次排序
            for (int j = 0; j < L; j++){
                result[i * L + j] = array[i][j];
            }
        }
        Arrays.sort(result);//排序
        return result;
    }


    /**
     * 不断进行两两数组的合并
     * @param array
     * @return
     */
    public static int[] mergeNArrays2(int[][] array) {
        int N = array.length, L;
        if (N == 0) {
            return new int[0];
        }

        //数组内容校验
        L = array[0].length;
        for (int i = 1; i < N; i++){
            if (L != array[i].length){
                return new int[0];
            }
        }

        int[] result = new int[N * L];//定义新数组
        for (int m=0;m<L;m++){
            result[m] = array[0][m];
        }
        for (int i=1;i<N;i++){
            mergeTwoArray(result,L * i,array[i],L);
        }
        return result;
    }

    private static void mergeTwoArray(int[] nums1, int m, int[] nums2, int n) {
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

    public static int[] testMergeNArrays(int[][] array) {
        int N = array.length, L;
        if (N == 0) {
            return new int[0];
        }
        L = array[0].length;
        for (int i=1;i<N;i++){
            if (L != array[i].length){
                return new int[0];
            }
        }

        int[] result = new int[N * L];
        for (int m=0;m<N;m++){
            for (int j=0;j<L;j++){
                result[m * L + j] = array[m][j];
            }
        }
        Arrays.sort(result);
        return result;
    }
}
