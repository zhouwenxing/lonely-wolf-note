package com.lonely.wolf.note.array;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组的初始化
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/12
 * @since jdk1.8
 */
public class $1_InitArray {
    public static void main(String[] args) {
        //方法一（可以通过循环赋值）
//        int arr[] = new int[5];
//        int[] arr1 = new int[5];
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(arr1.length);
        //方法二
//        int[] arr3 = {1,2,3,4};
//        System.out.println(Arrays.toString(arr3));

        //方法三
//        int[] arr4 = new int[]{1,2,3};
//        System.out.println(Arrays.toString(arr4));


//        List list = new ArrayList<>(16);
//        list.add(1);
//        System.out.println(list.size());


        int[] arr = new int[5];
        System.out.println(arr.length);
        arr[0] = 1;
        System.out.println(Arrays.toString(arr));


    }
}
