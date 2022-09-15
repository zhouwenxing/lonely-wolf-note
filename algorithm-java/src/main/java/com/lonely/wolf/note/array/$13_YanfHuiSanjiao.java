package com.lonely.wolf.note.array;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;


/**
 * 杨辉三角问题
 */
public class $13_YanfHuiSanjiao {

    public static void main(String[] args) {
//        printAllLine();
        printLastLine(10);
        printLastLine2(10);
    }


    /**
     * LeetCode 118 打印杨辉三角的所有航
     * LeetCode 119 打印杨辉三角的最后一行
     *
     * 杨辉三角特点：
     * 1.每一行的第一位和最后一位都是1，所以前两行都是1
     * 2.中间的数字是上一行数字的左上角和右上角之和。即：a[i][j] = a[i-1][j-1] + a[i-1][j]
     * 3.每一行元素的个数都和其行数一样
     *
     * 解题思路1：遍历赋值，需注意特殊情况下赋值处理
     */
    public static void printAllLine(){
        int arr[][] = new int[10][];
        for (int i=0;i<arr.length;i++){
            arr[i] = new int[i+1];
            arr[i][0] = 1;//头尾赋值为1
            arr[i][i]=1;//头尾赋值为1

            if (i >= 2){//赋值中间部分
                for (int j=1;j<=i-1;j++){
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
        }
        //打印
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.print("");
        }
    }


    /**
     * @Param rowIndex 杨辉三角行数
     * 打印最后一行
     * 解题思路2：二维数组占用空间较大，因每次打印下一行只用到了上一行，可以利用递归方法节省空间进行打印
     */
    public static void printLastLine(int rowIndex){
        List<Integer> list = new ArrayList<>(16);
        list.add(1);//第一个元素是1
        for (int i=1;i<=rowIndex-1;++i){
            list.add(0);//防止61行空指针
            for (int j=i;j>0;--j){
                list.set(j,list.get(j)+list.get(j-1));
            }
        }
        for (Integer a : list){
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    /**
     * 利用固定数组，这种必须知道数组大小，没有使用list灵活
     * @param rowIndex
     */
    public static void printLastLine2(int rowIndex){
        int arr[] = new int[10];
        arr[0] = 1;//第一个元素是1
        for (int i=1;i<=rowIndex-1;++i){
            for (int j=i;j>0;--j){
                arr[j] = arr[j]+arr[j-1];
            }
        }
        for (Integer a : arr){
            System.out.print(a + " ");
        }
        System.out.println("");
    }
}
