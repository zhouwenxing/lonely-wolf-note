package com.lonely.wolf.note.str;

import java.util.*;

/**
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/30
 * @since jdk1.8
 */
public class $4_ReverseStr2 {
    public static void main(String[] args) {
//        String s1 = "ab-cd";
//        String s2 = "a-bC-dEf-ghIj";
//        String s3 = "Test1ng-Leet=code-Q!";
//        System.out.println(reverseOnlyLetters(s1));
//        System.out.println(reverseOnlyLetters(s2));
//        System.out.println(reverseOnlyLetters(s3));

//        String s11 = "the sky is blue";
//        String s22 = "hello world";
//        System.out.println(reverseWordByJavaApi(s11));
//        System.out.println(reverseWordByJavaApi(s22));


//        String s33 = " the   sky   is   blue  ";
//        String s44 = "  hello   world   ";
//        System.out.println(reverseWordByDoublePoint(s33));
//        System.out.println(reverseWordByDoublePoint(s44));


        String s111 = "Let's take LeetCode contest";
        System.out.println(reverseWordLetterByDoublePoint(s111));
    }

    /**
     *  LeetCode.917. 仅仅反转字⺟
     *
     * 给定⼀个字符串 S ，返回 “反转后的” 字符串，其中不是字⺟的字符都保留在原地，⽽所有字⺟的位置发⽣反转。
     *
     * 示例1：输⼊："ab-cd"  输出："dc-ba"
     * 示例2：输⼊："a-bC-dEf-ghIj" 输出："j-Ih-gfE-dCba"
     * 示例3：输⼊："Test1ng-Leet=code-Q!" 输出："Qedo1ct-eeLg=ntse-T!"
     *
     * 解题思路：快慢双指针
     * 或者可以用一个栈来存储字符，最后将字母出栈逐个替换源字符串中的字母
     *
     * 此方法采用的是快慢双指针法
     *
     * @param s
     * @return
     */
    public static String reverseOnlyLetters(String s){
        if (null == s || s.length() == 0){
            return "";
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if (Character.isLetter(chars[left]) && Character.isLetter(chars[right])){
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
                continue;
            }
            if (!Character.isLetter(chars[left])){
                left++;
            }
            if (!Character.isLetter(chars[right])){
                right--;
            }
        }
        return String.valueOf(chars);
    }



    /**
     *  LeetCode151. 反转字符串⾥的单词
     *
     * 给你⼀个字符串 s ，逐个反转字符串中的所有单词 。单词是由⾮空格字符组成的字符串。s 中使⽤⾄少⼀个空格将字符串中的单词分隔开。
     * 请你返回⼀个反转 s 中单词顺序并⽤单个空格相连的字符串.
     * 说明：
     * 输⼊字符串 s 可以在前⾯、后⾯或者单词间包含多余的空格。
     * 反转后单词间应当仅⽤⼀个空格分隔。
     * 反转后的字符串中不应包含额外的空格。
     *
     * 示例1：输⼊：s = "the sky is blue"  输出："blue is sky the"
     * 示例2：输⼊：s = "hello world"  输出："world hello"
     *
     * 解题思路：
     * 通过Java API 先按照空格 split，然后反转单词
     *
     *
     * @param s
     * @return
     */
    public static String reverseWordByJavaApi(String s){
        if (null == s || s.length() == 0){
            return "";
        }
        String[] arr = s.split("\\s+");
        List<String> wordList = Arrays.asList(arr);
        Collections.reverse(wordList);
        return String.join(" ",wordList);
    }


    /**
     *  LeetCode151. 反转字符串⾥的单词
     *
     * 给你⼀个字符串 s ，逐个反转字符串中的所有单词 。单词是由⾮空格字符组成的字符串。s 中使⽤⾄少⼀个空格将字符串中的单词分隔开。
     * 请你返回⼀个反转 s 中单词顺序并⽤单个空格相连的字符串.
     * 说明：
     * 输⼊字符串 s 可以在前⾯、后⾯或者单词间包含多余的空格。
     * 反转后单词间应当仅⽤⼀个空格分隔。
     * 反转后的字符串中不应包含额外的空格。
     *
     * 示例1：输⼊：s = "the sky is blue"  输出："blue is sky the"
     * 示例2：输⼊：s = "hello world"  输出："world hello"
     *
     * 解题思路：
     * 1、首先将字符串转变成可变字符，如 StringBuilder
     * 2、将字符串存入 StringBuilder，并删除多余的空格
     * 3、将整个字符串反转
     * 4、将字符串按单词反转
     *
     *
     * @param s
     * @return
     */
    public static String reverseWordByDoublePoint(String s){
        if (null == s || s.length() == 0){
            return "";
        }

        int left = 0;
        int right = s.length() - 1;

        while (left <= right && s.charAt(left) == ' '){//删除字符串前面空格
            left++;
        }
        while (left <= right && s.charAt(right) == ' '){//删除字符串后面空格
            right--;
        }

        //删除字符串中多余空格
        StringBuilder sb = new StringBuilder();
        char preChar = s.charAt(left);
        while (left <= right){
            char c = s.charAt(left);
            if (c != ' ' || preChar != ' '){
                sb.append(c);
            }
            preChar = c;
            left++;
        }

        reverse(sb,0,sb.length() - 1);//反转整个字符串

        left = 0;
        int start = 0;
        while (left <= sb.length() - 1){
            if (sb.charAt(left) == ' ' || left == sb.length() - 1){
                reverse(sb,start,(left == sb.length() - 1) ? left : left - 1);
                start = left + 1;
            }
            left++;
        }
        return sb.toString();
    }



    /**
     * LeetCode557. 反转字符串中的单词 III
     *
     * 给定⼀个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     * 示例：输⼊："Let's take LeetCode contest"  输出："s'teL ekat edoCteeL tsetnoc"
     *
     * @param s
     * @return
     */
    public static String reverseWordLetterByDoublePoint(String s){
        if (null == s || s.length() == 0){
            return "";
        }

        //删除字符串中多余空格
        StringBuilder sb = new StringBuilder();

        int start = 0;
        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if (c == ' '){//如果是空格，则直接添加，并继续循环
                sb.append(c);
                continue;
            }
            //不是空格，则记录当前单词的起始位置
            start = i;
            //1、i 没到结尾 2、i 的下一个位置已经是空格，则暂停循环
            while (i < s.length() && (i == s.length() -1 || s.charAt(i+1) != ' ')){
                i++;
            }
            //如果是最后一个字母，那么i会多走一次，所以需要退回去一步
            if(i >  s.length() -1){
                i = s.length() - 1;
            }
            // 将上一个单词倒序插入
            for (int j=i;j>=start;j--){
                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }


    private static void reverse(StringBuilder sb, int left, int right) {
        while (left <= right){
            char temp = sb.charAt(left);
            sb.setCharAt(left++,sb.charAt(right));
            sb.setCharAt(right--,temp);
        }
    }
}
