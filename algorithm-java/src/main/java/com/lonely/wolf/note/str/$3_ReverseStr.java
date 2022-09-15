package com.lonely.wolf.note.str;

/**
 * 字符串反转相关算法
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/28
 * @since jdk1.8
 */
public class $3_ReverseStr {
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println("字符串反转后：" + reverseString(s.toCharArray()));
        System.out.println("k个一组反转后：" + reverseStringByKGroup(s,2));

        String s2 = "abcd";
        System.out.println("字符串反转后：" + reverseString(s2.toCharArray()));
        System.out.println("k个一组反转后：" + reverseStringByKGroup(s2,2));


        String s3 = "abcdefghijklmnopq";
        System.out.println("k个一组反转后：" + reverseStringByKGroup(s3,3));


    }


    /**
     * 题目要求：
     * 编写⼀个函数，其作⽤是将输⼊的字符串反转过来。输⼊字符串以字符数组 s 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输⼊数组、使⽤ O(1) 的额外空间解决这⼀问题。
     *
     * 解题思路：
     * 双指针处理，left 指向 0，right 指向 len-1,互相交互，交换之后 lrft++right--，直到 left >= right 则停止
     *
     *
     * @param chars
     */
    public static String reverseString(char[] chars) {
        if (null == chars || chars.length == 0){
            return "";
        }
        int left = 0;
        int right = chars.length - 1;
        while (left < right){
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return String.valueOf(chars);
    }




    /**
     * 题目要求：
     * 给定⼀个字符串 s 和⼀个整数 k，从字符串开头算起，每计数⾄ 2k 个字符，就反转这 2k 字符中的前 k 个字符。
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符⼩于 2k 但⼤于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *
     *
     *
     * 解题思路：
     * 双指针处理，left 指向 0，right 指向 len-1,互相交互，交换之后 lrft++right--，直到 left >= right 则停止
     *
     *
     * @param s
     * @param k
     */
    public static String reverseStringByKGroup(String s,int k) {
        if (null == s || "".equals(s)){
            return "";
        }
        char[] chars = s.toCharArray();

        int groupNum = 2 * k;
        int groupCount = s.length() / groupNum;
        int remain = s.length() % groupNum;

        for(int i=0;i<groupCount;i++){
            int left = i * groupNum;
            int right = i * groupNum +  groupNum/ 2 -1;
            reverse(chars,left,right);
        }
        if (remain >= k){
            remain = k;
        }

        int left = groupCount * groupNum;
        int right = groupCount * groupNum + remain - 1;
        reverse(chars,left,right);
        return String.valueOf(chars);
    }


    private static void  reverse(char[] chars,int left,int right){
        while (left < right){
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }




}
