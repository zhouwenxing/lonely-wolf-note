package com.lonely.wolf.note.array;


/**
 *
 * 数组排序专题
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/19
 * @since jdk1.8
 */
public class $3_SortArray {
    public static void main(String[] args) {
//        int[][] arr = {{1,2,3}};
//        System.out.println(Arrays.deepToString(arr));
//        System.out.println(Arrays.toString(arr));

        int[] arr1 = {1,8,4,2};
        int[] arr2 = {1,2,3,4};
        int[] arr3 = {4,3,2,1};
        int[] arr4 = {1,1,2,2};
        int[] arr5 = {3,3,2,2};
        System.out.println(sortType(arr1));
        System.out.println(sortType(arr2));
        System.out.println(sortType(arr3));
        System.out.println(sortType(arr4));
        System.out.println(sortType(arr5));

        System.out.println(sortType2(arr1));
        System.out.println(sortType2(arr2));
        System.out.println(sortType2(arr3));
        System.out.println(sortType2(arr4));
        System.out.println(sortType2(arr5));
    }


    /**
     *
     * 判断一个数组是否有序及排序类型
     * @param arr
     * @return -1-空数组 0-无序 1-升序 2-降序
     */
    public static int sortType(int[] arr){
        if (null == arr || arr.length == 0){
            return -1;
        }
        int result = 0;//默认无序
        for (int i=1;i<arr.length;i++){//循环时要注意越界
            if (arr[i-1] < arr[i]){//升序
                if (result == 2){
                    return 0;
                }
                result = 1;//升序
                continue;
            }
            if (arr[i-1] > arr[i]){//降序
                if (result == 1){
                    return 0;
                }
                result = 2;//降序
                continue;
            }
        }
        return result;//如果元素全部相等也会返回0
    }

    /**
     * 判断一个数组是否有序（即是否是单调数组）
     * @param arr
     * @return true-有序 false-无序
     */
    public static boolean sortType2(int[] arr){
        if (null == arr || arr.length == 0){
            return false;
        }
        boolean inc = false,dec = false;
        for (int i=1;i<arr.length;i++){//循环时要注意越界
            if (arr[i-1] < arr[i]){//升序
                inc = true;
            }
            if (arr[i-1] > arr[i]){//降序
                dec = true;
            }
            if (inc && dec){
                return false;
            }
        }
        return inc || dec;//如果数组元素全部相等会返回false
    }




}
