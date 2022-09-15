package com.lonely.wolf.note.array;

import java.util.Arrays;

/**
 * 奇偶数分离
 *
 * 输⼊⼀个整数数组，通过⼀个函数来调整该数组中数字的顺序，使得所有的偶数位于数组的前半部分，所有的奇数位于数组的后半部分。
 *
 * 验证1：输⼊：[3,1,2,4] 输出：[2,4,3,1]（或者输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3]均可 ）
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/20
 * @since jdk1.8
 */
public class $9_OdevityElementDivision {
    public static void main(String[] args) {
//        int[] arr = {3,1,2,4};
//        divideElement(arr);
//        System.out.println(Arrays.toString(arr));

//        int[] arr = {3,1,2,4};
        int[] arr = {3,6,8,9};
        testDivideElement(arr);
        System.out.println(Arrays.toString(arr));

//        int[] arr2 = {3,1,2,4};
//        divideElement2(arr2);
//        System.out.println(Arrays.toString(arr2));
//
//
//        int[] arr3 = {3,1,2,4};
//        divideElement3(arr3);
//        System.out.println(Arrays.toString(arr3));



    }


    /**
     * 双指针法
     *
     * 采用头尾元素交换法，思想类似于 $7的双指针交换移除元素法，会打破原有顺序
     * @param arr
     */
    public static void divideElement(int[] arr){
        if (null == arr || arr.length == 0){
            return;
        }

        int left = 0;
        int right = arr.length - 1;

       while (left < right){
//           if (arr[left] % 2 > arr[right] % 2){//左边奇数，右边偶数
           if (arr[left] % 2 == 1 && arr[right] % 2 == 0){//左边奇数，右边偶数
               int temp = arr[left];
               arr[left] = arr[right];
               arr[right] = temp;
           }
           if (arr[left] % 2 == 0){
               left++;
           }
           if (arr[right] % 2 == 1){
               right--;
           }
       }
    }



    /**
     * 冒泡排序法，比较奇偶，可以保证原有顺序
     *
     * 比较之后将偶数往前移动
     *
     * @param arr
     */
    public static void divideElement2(int[] arr){
        if (null == arr || arr.length == 0){
            return;
        }

        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                if ((arr[i] & 1) == 1 && (arr[j] & 1) == 0){//左边奇数，右边偶数
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    /**
     * 冒泡排序法
     *
     * 比较之后将奇数往后移
     * @param arr
     */
    public static void divideElement3(int[] arr){
        if (null == arr || arr.length == 0){
            return;
        }

        int n = arr.length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n-1-i; j++) {
                if ((arr[j] & 1) == 1 && (arr[j+1] & 1) == 0) {//左边奇数, 右边偶数
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }


    /**----------------------------------------------------以下为复盘练习使用方法---------------------------------------------*/

    public static void testDivideElement(int[] arr){
        if (null == arr || arr.length == 0){
            return;
        }
        int j=arr.length-1;
        for (int i=0;i<=j;i++){
            if (arr[i] % 2 == 0){
                int temp = arr[j];
                arr[j--] = arr[i];
                arr[i--] = temp;
            }
        }
    }
}
