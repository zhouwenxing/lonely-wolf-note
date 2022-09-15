package com.lonely.wolf.note.array;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 大厂冲刺题
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/07/27
 * @since jdk1.8
 */
public class $11_SprintExercise {

    public static void main(String[] args) {
//        StringBuffer s = new StringBuffer("We Are Happy");
//        System.out.println(replaceSpace(s));
//
//        char[] chars = new char[]{'W','e',' ','A','r','e',' ','H','a','p','p','y'};
//        System.out.println(JSONObject.toJSONString(replaceSpace2(chars)));

//        int[] arr = {1,1,1,2,2,3};
//        System.out.println(deleteRepeatElement(arr));
//
//        int[] arr2 = {1,1,1,2,2,3};
//        System.out.println(deleteRepeatElement2(arr2,2));

//        int M=10,N=2;
//        System.out.println(solve(M,N));


//        int[] arr3 = {4,2,5,7};
//        int[] arr33 = {4,2,5,7};
//        System.out.println(JSONObject.toJSONString(sortByParity1(arr3)));
//        System.out.println(JSONObject.toJSONString(sortByParity2(arr33)));


    }


    /**
     *
     * 剑指offer题目：请实现一个函数，将一个字符串中每个空格替换成“%20”。例如：当字符串为：We Are Happy，
     * 则经过替换后字符串为：We%20Are%20Happy，
     *
     * 思路：
     *
     *
     * 解法一：当字符串为可变长时，可直接遍历处理
     *
     * @param str
     */
    public static String replaceSpace(StringBuffer str) {
        if (StringUtils.isBlank(str)){
            return "";
        }
        String resStr = "";
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (c == ' '){
                resStr += "%20";
            }else{
                resStr += c;
            }
        }
        return resStr;
    }



    /**
     *
     * 剑指offer题目：请实现一个函数，将一个字符串中每个空格替换成“%20”。例如：当字符串为：We Are Happy，
     * 则经过替换后字符串为：We%20Are%20Happy，
     *
     * 思路：
     *
     *
     * 解法一：当字符串为不可变长时，需要先申请一个大空间来存储替换空格后的空间
     *
     * @param chars
     */
    public static char[] replaceSpace2(char[] chars) {
        if (null == chars || chars.length ==0){
            return chars;
        }

        int spaceNum = 0;
        for (int i=0;i<chars.length;i++){
            if (chars[i] == ' '){
                spaceNum++;
            }
        }

        char[] resChars = new char[chars.length + spaceNum * 2];
        int j = 0;
        for (int i=0;i<chars.length;i++){
            if (chars[i] == ' '){
                resChars[j++] = '%';
                resChars[j++] = '2';
                resChars[j++] = '0';
            }else {
                resChars[j++] = chars[i];
            }
        }
        return resChars;
    }


    /**
     * 给定一个有序数组nums,请你原地删除重复出现的元素，使每个元素最多出现2次，返回删除后数组出现的新长度
     * @param arr
     */
    public static int deleteRepeatElement(int[] arr) {
        if (null == arr){
            return 0;
        }
        if (arr.length <= 2){
            return arr.length;
        }
        int left = 2;
        int right = 2;
        while (right < arr.length){
            if (arr[left - 2] != arr[right]){
                arr[left++] = arr[right++];
            }else{
                right++;
            }
        }
        return left;
    }

    /**
     * 给定一个有序数组nums,请你原地删除重复出现的元素，使每个元素最多出现k次，返回删除后数组出现的新长度
     * @param arr
     * @param k
     */
    public static int deleteRepeatElement2(int[] arr,int k) {
        if (null == arr){
            return 0;
        }

        if (arr.length <= k){
            return arr.length;
        }

        int i=0;
        for (int num : arr){
            if (i < k || arr[i-k] != num){
                arr[i++] = num;
            }
        }
        return i;
    }


    /**
     * 元素加1
     * LeetCode66：给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加1。
     * 其中最高位数字存放在数组的首位，数组中每个元素只存储单个数字。你可以假设除了整数0之外，这个整数不会以0开头
     * @param arr
     * @return
     */
    public static int[] plusOne(int[] arr) {
        if (null == arr || arr.length == 0){
            return arr;
        }
        for (int i=arr.length-1;i>=0;i--){
            int result = arr[i]++;
            arr[i] = result % 10;
            if ((result % 10) != 0){//不等于0说明后续都不需要进位，可直接返回数组
                return arr;
            }
        }
        //到这里说明所有位都进1，即数组中全部位9，此时需要申请一个长度+1的数组进行存储
        int[] arr2 = new int[arr.length + 1];
        arr[0] = 1;//数组中默认是0，所以只需要给第一位赋值为1即可。
        return arr2;
    }


    /**
     * 进制转换
     * 给定一个十进制数 M，以及需要转换的进制数 N，将十进制数 M 转换为 N 进制数，其中 M 是 32 位整数，2<=N<=16
     * @param M
     * @param N
     * @return
     */
    public static String solve(int M,int N) {
        //存储进制的所有位数
        final String[] F = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

        boolean flag = true;//是否正数
        if (M < 0){
            flag = false;
            M *=-1;
        }
        StringBuffer sb = new StringBuffer();
        while (M != 0){
            int temp = M%N;//取余
            sb.append(F[temp]);
            M=M/N;//取模
        }
        sb.reverse();
        return (flag ? "":"-") + sb.toString();
    }


    /**
     * Leetcode 922 给定一个非负整数数组A，A中一半整数是奇数，一半整数是偶数，
     * 对数组进行排序，以便当：A[i]为奇数时，i也为奇数；当A[i]为偶数时，i也为偶数
     * 解题思路1：题目没说原地处理，最简单的方式就是定义一个新数组
     * @return
     */
    public static int[] sortByParity1(int[] nums) {
        if (null == nums || nums.length <=1){
            return null;
        }
        int[] resArr = new int[nums.length];
        int os = 0;//偶数
        int js = 1;//奇数
        for (int i=0;i<nums.length;i++){
            if (nums[i] % 2 == 0){//偶数
                resArr[os] = nums[i];
                os+=2;
            }else{
                resArr[js] = nums[i];
                js+=2;
            }
        }
        return resArr;
    }

    /**
     * Leetcode 922 给定一个非负整数数组A，A中一半整数是奇数，一半整数是偶数，
     * 对数组进行排序，以便当：A[i]为奇数时，i也为奇数；当A[i]为偶数时，i也为偶数
     * 解题思路2：原地处理
     * @return
     */
    public static int[] sortByParity2(int[] nums) {
        if (null == nums || nums.length <=1){
            return null;
        }

        int tempIndex = nums.length - 1;
        for (int i=nums.length-1;i>=0;i--){
            if (i % 2 == 0){//下标偶数
                if (nums[i] % 2 == 0){//元素偶数
                    tempIndex--;
                }else{//元素奇数
                    while (nums[tempIndex] % 2 != 0){
                        tempIndex--;
                    }
                    int temp = nums[i];
                    nums[i] = nums[tempIndex];
                    nums[tempIndex] = temp;
                    tempIndex = i-1;
                }
            }else{//下标奇数
                if (nums[i] % 2 != 0){//元素奇数
                    tempIndex--;
                }else{//偶数
                    while (nums[tempIndex] % 2 == 0){
                        tempIndex--;
                    }
                    int temp = nums[i];
                    nums[i] = nums[tempIndex];
                    nums[tempIndex] = temp;
                    tempIndex = i-1;
                }
            }
        }
        return nums;
    }


    /**
     * 剑指offer：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字，如果不存在这个数字，则输出：0
     * 解题思路1：采用hash存储数字及出现的次数
     * 解题思路2：将数组先进行排序。如果数组中的第一位和中位数都是同一个数，那就说明这个数肯定超过一半，否则不存在这样的数
     * 解题思路3（本方法解法）：如果一个数出现的次数超过数组长度的一半，也就是说它出现的次数比其他数字之和还要多。因此可以这么做：
     * 定义一个次数times=1，定义一个result=arr[0]，然后开始遍历。当遍历到下一个数字的时候，如果和result相同，则times+1，不同则times-1。
     * 当times=0时，替换result，继续遍历，最后剩下的result则可能是超过次数一半的元素（如果存在这样的元素那就一定是）
     * 最后再重新遍历一次，确认当前result出现次数是否超过一半，是则返回result，否则返回0
     *
     * @param nums
     * @return
     */
    public int moreThanHalfNumInArray(int[] nums){
        if (null == nums || nums.length == 0){
            return 0;
        }

        int length = nums.length;
        int times = 1;
        int result = nums[0];
        for (int i=0;i<length;i++){
            if (times == 0){
                result = nums[i];
                times = 1;
                continue;
            }

            if (nums[i] == result){
                times++;
            }else{
                times--;
            }
        }

        //重置次数，判断result是否超过一半
        times = 0;
        for (int i=0;i<length;i++){
            if (nums[i] == result){
                times++;
            }
            if (times > length / 2){
                return result;
            }
        }
        return 0;
    }


    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素都出现2次，找出那个只出现一次的元素。
     * 解题思路1：双层循环法
     * 解题思路2：hash法。利用set方法的add，成功返回true，返回false说明之前存在元素，重复了（必须2次，如果出现3次会有问题），直接移除，最后剩下的元素就是只出现一次的元素
     *
     * @param nums
     * @return
     */
    public Integer onlyOnceNumInArray(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int i : nums){
            if (!set.add(i)){
                set.remove(i);
            }
        }
        if (set.size() == 0){
            return null;
        }
        return set.toArray(new Integer[set.size()])[0];//set.toArray()[0]
    }


    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素都出现2次，找出那个只出现一次的元素。
     * 解题思路3：利用异或运算法：
     * 1、0^0=0
     * 2、0^a=a
     * 3、a^a=0
     * 4、a^b^a=b（这个特性确保了最后剩余的一定是单个数字，因为其他数字都出现了2次）
     *
     * @param nums
     * @return
     */
    public Integer onlyOnceNumInArray2(int[] nums){
        int flag = 0;
        for (int i : nums){
            flag ^=i;
        }
        return flag;
    }
}
