package com.lonely.wolf.note.array;


import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵问题
 */
public class $15_SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        printMatrix(matrix);//螺旋矩阵打印

        System.out.println(JSONObject.toJSONString(generateMatrix(3)));//螺旋矩阵生成

    }


    /**
     * 螺旋矩阵的打印：
     * 给你一个 m 行 n 列的矩阵 matrix，请按照顺时针螺旋顺序，返回矩阵中所有元素。
     *
     * 解题思路：关键是要确认四个角
     * @param matrix
     */
    public static void printMatrix(int[][] matrix){
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int topLeft = 0;
        int topRight = matrix[0].length - 1;
        int bottomLeft = 0;
        int bottomRight = matrix.length - 1;

        List<Integer> resList = new ArrayList<>();
        while (topLeft < (matrix.length+1)/2 && bottomLeft < (matrix[0].length+1)/2){
            for (int i=bottomLeft;i<=topRight;i++){
                resList.add(matrix[topLeft][i]);
            }
            for (int i=topLeft + 1;i<=bottomRight;i++){
                resList.add(matrix[i][topRight]);
            }
            for (int i=topRight-1;i>=bottomLeft && bottomRight != topLeft;i--){
                resList.add(matrix[bottomRight][i]);
            }
            for (int i=bottomRight-1;i>=(topLeft+1) && topRight != bottomLeft;i--){
                resList.add(matrix[i][bottomLeft]);
            }
            topLeft++;
            topRight--;
            bottomLeft++;
            bottomRight--;
        }
        System.out.println(JSONObject.toJSONString(resList));
    }


    /**
     * 螺旋矩阵的生成：
     * 给一个正整数 n,生成一个包含 1到 n2 所有元素，且元素按顺时针螺旋排列的 n * n 正方形矩阵 matrix。
     * 示例1：
     *   输入：n=3
     *   输出：[[1,2,3],[8,9,4],[7,6,5]],如下图所示：右边一列向下，左边一列向上。
     *     1 -> 2  -> 3
     *               |(下)
     *     8 -> 9 -> 4
     *    |(上)      |(下)
     *    7 <- 6 <- 5
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n){
        //确认边界
        int topLeft = 0;
        int topRight = n - 1;
        int bottomLeft = 0;
        int bottomRight = n - 1;
        int[][] matrix = new int[n][n];
        int start = 1;
        int end = n * n;
        while (start <= end){
            for (int i=bottomLeft;i<=topRight;i++){//上左到上右
                matrix[topLeft][i] = start++;
            }
            topLeft++;
            for (int i=topLeft;i<=bottomRight;i++){//上右到下右
                matrix[i][topRight] = start++;
            }
            topRight--;
            for (int i=topRight;i>=bottomLeft;i--){//下右到下左
                matrix[bottomRight][i] = start++;
            }
            bottomRight--;
            for (int i=bottomRight;i>=topLeft;i--){//下左到上左
                matrix[i][bottomLeft] = start++;
            }
            bottomLeft++;
        }
        return matrix;
    }


    /**
     * 矩阵置 0
     * 给定一个 m*n 的矩阵，如果一个元素为 0，则将其所在的行和列所有元素都设为 0。请用原地算法实现。
     *
     * 进阶：
     * 1.一个直观的解决方案是使用O(mn)的额外空间，但这并不是一个好的解决方案。
     * 2.一个简单的改进方案是使用O(m+n)的额外空间，但这仍然不是最好的解决方案。
     * 3.你能想出一个仅使用常量空间的解决方案吗？
     *
     * 解题思路1：最笨的方式是使用一个一样大小的二维数组来解决，但是题目要求使用原地算法，所以排除
     * 解题思路2：使用 2 个数组来解决
     *
     * @param matrix
     * @return
     */
    public static void matrixSetToZeroByTwoArray(int[][] matrix){
        if (null == matrix || matrix.length == 0){
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] rowArr = new boolean[row];
        boolean[] colArr = new boolean[col];

        //循环一次二维数组，并标记有0的行和列
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (matrix[i][j] == 0){
                    rowArr[i] = colArr[j] = true;
                }
            }
        }

        //再次循环二维数组，将有标记为 0 的行和列全部元素设为 0
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (rowArr[i] || colArr[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }


    /**
     * 矩阵置 0
     *
     * 解题思路3：通过两个变量来标记实现二维数组置 0
     * 在解题思路 2 上进行优化，我们不适用额外的 2 个数组来标记，而是直接使用第一行和第一列来进行标记。
     * 这种做法会改变第一行和第一列的元素，无法记录原第一行和第一列的元素原本是否包含 0，所以需要额外的 2 个变量来记录第一行和第一列元素是否原本就包含0
     *
     * 解题步骤：
     * 1.定义两个变量
     * 2.循环遍历判断第一行与第一列是否包含 0，并根据结果给 2 个变量赋值
     * 2.遍历循环其他行与列，如果含有 0则将第一行与第一列对应位置的元素设为 0
     * 3.反过来使用第一行与第一列的元素来更新其他行与列
     * 4.最后使用 2 个变量来更新第一行与第一列
     *
     * @param matrix
     */
    public static void matrixSetToZeroByTwoVar(int[][] matrix){
        if (null == matrix || matrix.length == 0){
            return;
        }
        //1.定义两个变量来标记原第一行和第一列中的元素是否包含 0
        int row = matrix.length;
        int col = matrix[0].length;
        boolean row0Flag = false;//第一行元素是否包含 0
        boolean col0Flag = false;//第二行元素是否包含 0

        //判断第一行元素是否含有 0
        for (int i=0;i<col;i++){
            if (matrix[i][0] == 0){
                row0Flag = true;
                break;
            }
        }

        //判断第一列元素是否含有 0
        for (int i=0;i<row;i++){
            if (matrix[0][i] == 0){
                col0Flag = true;
                break;
            }
        }

        //2.遍历其他行与其他列，判断是否包含 0，如果包含 0，则将第一行与第一列对应位置的元素设置为 0

        for (int i=1;i<row;i++){//首次循环，在第一行和第一列中标记其他行与列是否包含 0
            for (int j=1;j<col;j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i=1;i<row;i++){//再次循环，根据第一行和第一列的标记，将其他行与列对应位置元素设置为 0
            for (int j=1;j<col;j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        //3.通过之前定义的 2 个变量来判断是否需要将第一行和第一列的元素全部改为 0
        if (row0Flag){
            for (int i=0;i<col;i++){
                matrix[0][i] = 0;
            }
        }
        if (col0Flag){
            for (int i=0;i<row;i++){
                matrix[i][0] = 0;
            }
        }
    }


    /**
     * LeetCode 48
     * 给定一个 n*n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     * 你必须在【原地】旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     *
     * 解题思路1：利用另一个矩阵来临时存储，最后再替换回来（这种方法不符合题目要求，但是仍然是一种解题思路）
     * 通过画图找规律，可以发现，旋转90°后，对于矩阵中第 i 行的第 j 个元素，在旋转后，它出现在倒数第 i 列的第 j 个位置。
     * 也就是可以得到：matrix[row][col] = matrix[col][n-row-1]
     * 知道这个规律，利用辅助数据就比较容易写代码了
     *
     *
     * @param matrix
     */
    public static void rotateWithNewArray(int[][] matrix) {
        if (null == matrix || matrix.length == 0){
            return;
        }
        int n = matrix.length;
        int[][] new_matrix = new int[n][n];
        //使用新数组存贮转换后的元素
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                new_matrix[j][n-i-1] = matrix[i][j];
            }
        }
        //将新旧数组替换
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
               matrix[i][j] = new_matrix[i][j];
            }
        }
    }


    /**
     * 解题思路2：原地逐个替换：假设有A,B,C,D四个点，可以用：temp存储A，B替换A，C替换B，D替换C
     * 这个解法有 2 个关键点：1.是替换到哪个位置停下来 2.是需要替换哪些位置，怎么替换
     * 根据解题思路1中，有：matrix[col][n−row−1]=matrix[row][col]
     * 也就是：row=col && col=n-row-1
     * 所以又可以得到：matrix[n−row−1][n−col−1] = matrix[col][n−row−1]
     * 依次计算，可以得到4个位置的替换点：
     * temp = matrix[n−col−1][row]
     * matrix[n−col−1][row] = matrix[n−row−1][n−col−1]
     * matrix[n−row−1][n−col−1] = matrix[col][n−row−1]
     * matrix[col][n−row−1] = matrix[row][col]
     * 也就是：temp=A=matrix[row][col]，B=matrix[col][n−row−1]，C=matrix[n−row−1][n−col−1]，D=matrix[n−col−1][row]
     *
     *
     * @param matrix
     */
    public static void rotateWithReplaceOneByOne(int[][] matrix) {


    }



    /**
     * 解题思路3：两次翻转法
     * 1 2 3                     1 4 7                                     7 4 1
     * 4 5 6   沿着159直线翻转得到： 2 5 8  再沿456翻转，即可得到顺时针90°旋转的结果: 8 5 2
     * 7 8 9                     3 6 9                                     9 6 3
     * @param matrix
     */
    public static void rotateWithTwoRollback(int[][] matrix) {
        int n = matrix.length;
        //斜对角线对折
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //中间竖线对折
        for (int i=0;i<n;i++){
            for (int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }

    }
}
