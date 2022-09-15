package com.lonely.wolf.note.exercise.complexity;

/**
 * 空间复杂度例子
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/10
 * @since jdk1.8
 */
public class SpaceDemo {
    public static void main(String[] args) {
        init(100);//O(n)空间复杂度

    }

    public static void init(int n){
        int a = 0;
        int arr[] = new int[n];
        for (int i=0;i<n;i++){
            arr[i]=n;
        }
    }
}
