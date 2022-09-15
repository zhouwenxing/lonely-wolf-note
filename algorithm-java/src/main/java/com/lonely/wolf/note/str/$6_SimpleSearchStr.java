package com.lonely.wolf.note.str;

import java.util.*;

/**
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/28
 * @since jdk1.8
 */
public class $6_SimpleSearchStr {

    public static void main(String[] args) {

    }


    /**
     * 给定⼀个字符串，找到它的第⼀个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * @param s
     * @return
     */
    public static int firstUniqueChar(String s){
        if (null == s || s.length() == 0){
            return -1;
        }

        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        for (int i = 0; i< s.length();i++){
            if (map.getOrDefault(s.charAt(i),0) == 1){
                return i;
            }
        }
        return -1;
    }


    /**
     * LeetCode58. 最后⼀个单词的⻓度。
     *
     * 给你⼀个字符串 s，由若⼲单词组成，单词前后⽤⼀些空格字符隔开。返回字符串中最后⼀个单词的⻓度。
     * 单词 是指仅由字⺟组成、不包含任何空格字符的最⼤⼦字符串。
     *
     *
     *
     * @param s
     * @return
     */
    public static int lastWordLength(String s){
        if (null == s || s.length() == 0){
            return -1;
        }

        int i = s.length() - 1;

        while (i >=0 && s.charAt(i) == ' '){//先把末尾空格去掉
            i--;
        }

        int wordLength = 0;
        while (i >=0 && s.charAt(i) != ' '){//因为题目限制了只有空格和字母，所以可以这么做
            wordLength++;
            i--;
        }
        return wordLength;
    }


}
