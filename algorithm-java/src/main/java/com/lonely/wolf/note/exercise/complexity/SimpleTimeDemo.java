package com.lonely.wolf.note.exercise.complexity;

/**
 * 时间复杂度例子
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/9
 * @since jdk1.8
 */
public class SimpleTimeDemo {
    public static void main(String[] args) {
        //常数阶 O(1)
//        print(10000);
        //线性阶 O(n)
//        print1(1000);
        //对数阶 O(logn)
//        print2(10000);
        //线性对数阶 O(nlogn)
        print3(8);

    }



    public static void print(int n){
        int a = 1;
        int b = 2;
        int c = 3;
        int sum = a + b + c;
        System.out.println(sum);
    }

    public static void print1(int n){
        int a = 0;
        for (int i=0;i<n;i++){
            System.out.println(i);
        }
    }

    public static void print2(int n){
        int i=1;
        while (i <= n) {
            i = i * 2;
        }
    }

    public static void print3(int n){
        for (int j=1;j<=n;j++){
            int i = 1;
            while (i <= n) {
                i = i * 2;
                System.out.println(i);
            }
        }
    }




}
