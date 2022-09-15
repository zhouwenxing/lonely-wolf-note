package com.lonely.wolf.note.exercise.complexity;

/**
 * 时间复杂度示例
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/10
 * @since jdk1.8
 */
public class TimeDemo {
    public static void main(String[] args) {
        int index = findEle(new int[]{1,2,3},1);
        System.out.println(index);
    }

    public static int findEle(int[] arr,int val){
        if (null == arr || arr.length == 0){
            return -1;
        }
       for (int i=0;i<arr.length;i++){
           if (arr[i] == val){
               return i;
           }
       }
       return -1;
    }
}
