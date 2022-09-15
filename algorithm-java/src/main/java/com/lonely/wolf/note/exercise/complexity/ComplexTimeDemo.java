package com.lonely.wolf.note.exercise.complexity;

/**
 * 多段复杂度代码组合
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/9
 * @since jdk1.8
 */
public class ComplexTimeDemo {
    public static void main(String[] args) {
        print1(1000);//O(n^2)，取最大值作为复杂度
        print2(1000,1000);//O(m+n)，无法确定最大值，取两数之和作为复杂度

    }

    public static void print1(int n){
        for (int i=0;i<1000;i++){
            System.out.println(i);
        }
        for (int j=0;j<n;j++){
            System.out.println(j);
        }

        for (int p=0;p<n;p++){
            for (int q=0;q<n;q++){
                System.out.println(p+q);
            }
        }
    }

    public static void print2(int m,int n){
        for (int i=0;i<1000;i++){
            System.out.println(i);
        }
        for (int j=0;j<m;j++){
            System.out.println(j);
        }
        for (int k=0;k<n;k++){
            System.out.println(k);
        }
    }
}
