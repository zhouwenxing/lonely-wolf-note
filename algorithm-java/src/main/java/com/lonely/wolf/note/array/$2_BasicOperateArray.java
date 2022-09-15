package com.lonely.wolf.note.array;

import java.util.Arrays;

/**
 * 数组基本增删改查操作
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/12
 * @since jdk1.8
 */
public class $2_BasicOperateArray {
    public static void main(String[] args) {
        int[] arr1 = null;
        addByIndex(arr1,4,4,2);
        System.out.println(Arrays.toString(arr1));


        //通过元素有序插入
        int[] arr2 = new int[10];
        arr2[0] = 3;
        arr2[1] = 4;
        arr2[2] = 7;
        arr2[3] = 8;

        //添加元素-方法一测试
//        addByElementSequence1(arr2, 4, 6);//中间位置插入
//        System.out.println(Arrays.toString(arr2));
//
//        addByElementSequence1(arr2, 5, 9);//尾部插入
//        System.out.println(Arrays.toString(arr2));
//
//        addByElementSequence1(arr2, 6, 0);//头部插入
//        System.out.println(Arrays.toString(arr2));


        //添加元素-方法二测试
        addByElementSequence2(arr2, 4, 6);//中间位置插入
        System.out.println(Arrays.toString(arr2));

        addByElementSequence2(arr2, 5, 9);//尾部插入
        System.out.println(Arrays.toString(arr2));

        addByElementSequence2(arr2, 6, 0);//头部插入
        System.out.println(Arrays.toString(arr2));


        int size = 7;
        removeByIndex(arr2,size,1);
        System.out.println(size);

    }


    /**
     * 寻找指定下标的数组元素
     * @param arr - 指定数组
     * @param index 要查找的位置
     * @return
     */
    public static int findByIndex(int[] arr, int size, int index) {
        if (index < 0 || index > size - 1){
            return -99999;
        }
        return arr[index];
    }

    /**
     * 寻找指定元素在数组中的下标
     * @param arr - 指定数组
     * @param element 要查找的元素
     * @return
     */
    public static int findIndexByElement(int[] arr, int size, int element) {
       for (int i=0;i<size;i++){
           if (arr[i] == element){
               return i;
           }
       }
        return -1;
    }


    /**
     * 指定数组中在指定下标添加元素
     * @param arr - 数组
     * @param size - 当前数组中已有元素个数
     * @param index - 添加下标
     * @param value - 添加到数组中的值
     */
    public static void addByIndex(int[] arr, int size, int index, int value) {
        if (null == arr || arr.length == 0){
            return;
        }
        //判断数组是否已满
        if (size >= arr.length){
            return;
        }
        //判断index是否越界
        if (index < 0 || index > arr.length - 1){
            return;
        }

        //将插入元素位置及之后元素往后移动一位
        for (int i = size-1;i>=index;i--){
            arr[i+1] = arr[i];
        }
        arr[index] = value;
        size++;
    }


    /**
     * 将给定的元素插⼊到有序数组的对应位置中:
     * 方法一：查找位置后插入
     * @param arr - 指定数组
     * @param size - 数组已经存储的元素数量
     * @param element - 待插入的元素
     * @return
     */
    public static void addByElementSequence1(int[] arr, int size, int element) {
        //数组是否为空
        if (null == arr || arr.length == 0){
            return;
        }
        //数组是否有空闲位置
        if (size >= arr.length){
            return;
        }
        //如果面试题需要确认数组是递增还是递减，在这里假设就是递增
        int index = size;
        //第一步:循环中找到需要插入的位置
        for (int i=0;i<size;i++){
            if (arr[i] > element){
                index = i;
                break;
            }
        }
        addByIndex(arr,size,index,element);
    }


    /**
     * 将给定的元素插⼊到有序数组的对应位置中:
     * 方法二：从后往前，逐步比较插入
     * @param arr - 指定数组
     * @param size - 数组已经存储的元素数量
     * @param element - 待插入的元素
     * @return
     */
    public static void addByElementSequence2(int[] arr, int size, int element) {
        //数组是否为空
        if (null == arr || arr.length == 0){
            return;
        }
        //确认数组至少有一个空位
        if (size >= arr.length){
            return;
        }
        //如果面试题需要确认数组是递增还是递减，在这里假设就是递增
        boolean succ = false;
        for (int i= size -1;i>=0;i--){
            if (arr[i] > element){//比较确认插入位置
                arr[i+1] = arr[i];//这里不会越界是因为方法中的第二个判断确保了数据至少有一个空位
            }else{
                arr[i+1] = element;
                succ = true;
                break;
            }
        }
        if (!succ){
            arr[0] = element;
        }
    }


    /**
     * 使用 O(1) 时间复杂度在给定数组的指定位置插入元素，可以忽略顺序
     * @param arr - 指定数组
     * @param size - 数组中有效元素
     * @param index - 指定插入下标
     * @param element - 指定插入元素
     */
    public static void addByElement(int[] arr, int size, int index,int element) {
        //数组是否为空
        if (null == arr || arr.length == 0){
            return;
        }
        //确认数组至少有一个空位
        if (size >= arr.length){
            return;
        }
        arr[size] = arr[index];
        arr[index] = element;
    }


    /**
     * 移除数组中指定下标的元素。将 index 之后的元素往前移动一位，同时更新size即可
     * @param arr - 指定数组
     * @param size - 当前数组元素数量
     * @param index 删除位置
     * @return
     */
    public static void removeByIndex(int[] arr, int size, int index) {
        //数组是否为空
        if (null == arr || arr.length == 0){
            return;
        }
        if (index < 0 || index > size -1){
            return;
        }
//        int ret = arr[index];//删除元素
        for (int i = index;i < size;i++){
            arr[i-1] = arr[i];
        }
        size--;
    }

    /**
     * 移除指定元素
     * @param arr - 指定数组
     * @param size - 当前数组元素数量
     * @param element 待删除元素
     * @return
     */
    public static void removeElement(int[] arr, int size, int element) {
        //数组是否为空
        if (null == arr || arr.length == 0){
            return;
        }

        if (size < 0 || size > size -1){
            return;
        }
        int index = findIndexByElement(arr,size,element);
        if (index >=0){
            removeByIndex(arr,size,index);
        }
    }
}
