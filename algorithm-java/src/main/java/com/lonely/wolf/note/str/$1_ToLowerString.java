package com.lonely.wolf.note.str;

/**
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/27
 * @since jdk1.8
 */
public class $1_ToLowerString {
    public static void main(String[] args) {
//        String s = "12QSDaaa";
//        System.out.println(toLower(s));

        String s2 = "42";
        System.out.println(strToNum(s2));
        String s3 = "    -42";
        System.out.println(strToNum(s3));
        String s4 = "4193 with words";
        System.out.println(strToNum(s4));
        String s5 = "words and 987";
        System.out.println(strToNum(s5));
        String s6 = "-91283472332";
        System.out.println(strToNum(s6));
    }


    /**
     * LeetCode709. 转换成⼩写字⺟
     *
     * 给你⼀个字符串 s ，将该字符串中的⼤写字⺟转换成相同的⼩写字⺟，返回新的字符串
     * @param str
     * @return
     */
    public static String toLower(String str){
        if (null == str || "".equals(str)){
            return str;
        }

        char [] chars = str.toCharArray();
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            //方法一
            if (c >= 65 && c <= 90){
                chars[i] = (char) (c + 32);
            }
            //方法二
            if (c >= 'A' && c <= 'Z'){
                chars[i] = (char) (c + 32);
            }
        }
        return String.valueOf(chars);
    }


    /**
     * LeetCode8. 字符串转换整数 (atoi)
     *
     * 字符串转换整数
     *
     * @param str
     * @return
     */
    public static int strToNum(String str){
        if (null == str || "".equals(str)){
            return 0;
        }
        int len = str.length();
        int index = 0;
        char[] chars = str.toCharArray();
        //去空格
        while (index < len && ' ' == chars[index]){
            index++;
        }
        if (index == len){
            return 0;
        }

        //解析 + - 符号
        boolean positive = true;//正数
        if (chars[index] == '+'){
            index++;
        }else if (chars[index] == '-'){
            positive = false;
            index++;
        }
        if (index == len){
            return 0;
        }

        //处理非数字类字符
        if (chars[index] < '0' || chars[index] > '9') {
            return 0;
        }

        //去掉数字前面的 0
        while (chars[index] == '0' && index < len){
            index++;
        }
        if (index == len){
            return 0;
        }

        //处理数字
        int result = 0;
        int currNum = 0;
        while (index < len && (chars[index]) >= '0' && chars[index] <= '9'){
            currNum = chars[index] - '0';
            if (positive && (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && currNum >= Integer.MAX_VALUE % 10)) {//正数越界
                return Integer.MAX_VALUE;
            }else if (!positive && (-result < Integer.MIN_VALUE / 10 || -result == Integer.MIN_VALUE / 10 && currNum >= -(Integer.MIN_VALUE % 10))){//负数越界
                return Integer.MIN_VALUE;
            }
            result = result * 10 + currNum;
            index++;
        }
        return positive ? result : -result;
    }
}
