package com.lonely.wolf.note.array;


import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 机器人路径相关问题
 */
public class $14_MatcinePath {


    public static void main(String[] args) {
//        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        printCircle(arr);

//        int m=7,n=1;
//        System.out.println(searchPathsByRecursion(m,n));
//        System.out.println(searchPathsByArray(m,n));
//        System.out.println(searchPathsByDynamicArray(m,n));

        int[][] obstacleGrid = {{0,0,0,0},{0,0,0,0},{0,1,0,0}};
        System.out.println(searchPathsWithObstacles(obstacleGrid));
    }


    /**
     * Leetcode 62 一个机器人位于 m*n 网格的左上角，机器人每次只能向下或者向右移动一步，
     * 机器人试图到达网格的右下角，问总共有多少总不同的路径
     *
     * 解题思路1：递归法
     * @param m
     * @param n
     * @return
     */
    public static int searchPathsByRecursion(int m,int n){
        if (m == 1 || n == 1){
            return 1;
        }
        return searchPathsByRecursion(m-1,n) + searchPathsByRecursion(m,n-1);
    }


    /**
     * 解题思路2：静态二位数组法
     * 递归解决方法会产生大量重复运算，比如在中间的某一个位置，不管从哪里走过来，这个位置的次数是固定的，
     * 所以可以计算好并存入二维数组，如下二维数组中，每个数字代表当前位置有多少种走法
     *    1  1  1
     *    1  2  3
     *    1  3  6
     * 观察二位数组，可以得到2个规律：
     * 1.第一行和第一列一定都是 1
     * 2.其他格子为其左侧和上方格子之和，如：2=1+1，6=3+3
     * 所以其实这就是一个杨辉三角
     * @param m
     * @param n
     */
    public static int searchPathsByArray(int m,int n){
        int[][] arr = new int[m][n];
        for (int i=0;i<m;i++){//第一列赋1
            arr[i][0] = 1;
        }
        for (int i=0;i<n;i++){//第一行赋1
            arr[0][i] = 1;
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m-1][n-1];//返回最后一个元素
    }


    /**
     * 解题思路3：动态数组法（只是用一维数组）
     * 静态二维数组有点浪费空间，实际上我们只需要知道当前位置的左边和上方元素，所以可以利用滚动数组方式，
     * 每次记录一行数组即可。比如我们准备记录第 n 行第2个位置，那么第一个位置元素已经记录，而当前元素恰好是新元素的上方，
     * 所以可以得到：a[n][2] = a[n-1][2]+a[n][2]，只存一维数组的话，就可以简化为：a[2] = a[1]+a[2]
     * @param m
     * @param n
     * @return
     */
    public static int searchPathsByDynamicArray(int m,int n){
        int[] arr = new int[n];
        Arrays.fill(arr,1);
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                arr[j] = arr[j-1] + arr[j];
            }
        }
        return arr[n-1];//返回最后一个元素
    }


    /**
     * Leetcode 63：在 Leetcode 62题的基础上，假如网格中某个位置存在障碍物，那么又该如何计算路径？
     * 解题思路：利用动态数组法，假设有障碍物的格子计为 1，没有障碍物的格子计为 0，那么执行的时候，
     * 当 arr[m][n] = 1时，直接跳过即可。
     *
     * @param obstacleGrid - 存在障碍物的 m*n 网格
     * @return
     */
    public static int searchPathsWithObstacles(int[][] obstacleGrid){
        if (obstacleGrid == null || obstacleGrid.length == 0){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] arr = new int[n];
        arr[0] = obstacleGrid[0][0] == 0 ? 1:0;//第一个位置先赋值，防止后面循环赋值时空指针

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (obstacleGrid[i][j] == 1){
                    arr[j] = 0;
                    continue;
                }
                if (j-1 >=0 && obstacleGrid[i][j-1] == 0){
                    arr[j] = arr[j-1] + arr[j];
                }
            }
        }
        return arr[n-1];//返回最后一个元素
    }
}
