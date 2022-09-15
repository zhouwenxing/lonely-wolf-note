package com.lonely.wolf.note.exercise.easy.binarySearch;

/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用bool isBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 官方题解
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/9/8
 * @since jdk1.8
 */
public class Algorithm2_2 {
    public static void main(String[] args) {

    }

    public static int firstBadVersion(int n) {
        int start = 1;
        while (start < n){
            int middle = (n-start)/2 + start;
            if (isBadVersion(middle)){
                n = middle;
            }else {
                start = middle + 1;
            }
        }
        return start;//当只剩一个的时候，可以直接返回，因为当前就是没通过检测，所以一定有一个不合格
    }


    public static boolean isBadVersion(int n) {
        return false;
    }
}
