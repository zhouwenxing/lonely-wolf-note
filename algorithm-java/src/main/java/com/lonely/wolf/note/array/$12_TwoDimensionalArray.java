package com.lonely.wolf.note.array;

public class $12_TwoDimensionalArray {

    public static void main(String[] args) {
//        printMultiplicationTables();
//        printMultiplicationTables2();
        printMatrix();

    }


    /**
     * 打印乘法口诀表（普通打印）
     */
    public static void printMultiplicationTables(){
        for (int i=1;i<=9;i++){
            for (int j=1;j<=i;j++){
                System.out.print(i + "*" + j + "=" + i * j);
                System.out.print("\t");//空格
            }
            System.out.println();
        }
    }


    /**
     * 打印乘法口诀表（二维数组打印）
     */
    public static void printMultiplicationTables2(){
        int arr[][] = new int[10][];
        for (int i=1;i<arr.length;i++){
            arr[i] = new int[i+1];
            for (int j=1;j<arr[i].length;j++){
                arr[i][j] = i * j;
                System.out.print(i + "*" + j + "=" + arr[i][j]);
                System.out.print("    ");
            }
            System.out.println();
        }
    }


    /**
     * 打印矩阵
     */
    public static void printMatrix(){
        int arr[][] = new int[10][10];
        for (int i=1;i<arr.length;i++){
            for (int j=1;j<arr[i].length;j++){
                arr[i][j] = i * j;
                System.out.print(i + "*" + j + "=" + arr[i][j]);
                System.out.print("    ");
            }
            System.out.println();
        }

    }

}
