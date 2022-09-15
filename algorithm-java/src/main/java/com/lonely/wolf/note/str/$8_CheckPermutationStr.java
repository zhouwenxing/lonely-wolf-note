package com.lonely.wolf.note.str;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 判定是否互为字符重排：
 * 给定两个字符串 `s1` 和 `s2`，请编写⼀个程序，确定其中⼀个字符串的字符重新排列后，能否变成另⼀个字符串。
 *
 * 示例1：
 * 输⼊: s1 = "abcadfhg", s2 = "bcafdagh" 输出: true
 *
 * 示例2：
 * 输⼊: s1 = "abc", s2 = "bad" 输出: false
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/1/4
 * @since jdk1.8
 */
public class $8_CheckPermutationStr {
    public static void main(String[] args) {
        String s1 = "abc",s2 = "abcd";
        System.out.println(checkPermutationByHash1(s1,s2));
        System.out.println(checkPermutationByHash2(s1,s2));

    }


    /**
     * 解题思路：哈希法1
     *
     * 通过哈希法，不过哈希不仅仅记录存在某一个字符，还需要计算次数
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkPermutationByHash1(String s1,String s2){
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<s1.length();i++) {
            char c = s1.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        for (int i=0;i<s2.length();i++) {
            char c = s2.charAt(i);
            if (map.containsKey(c)){
                if (map.get(c) > 1){
                    map.put(c,map.get(c) -1);
                }else {
                    map.remove(c);
                }
            }else {
                return false;
            }
        }
        return true;
    }

    /**
     * 解题思路：哈希法2
     *
     * 1、遍历两个字符串，分别存入 map
     * 2、再遍历任意一个字符串，并比较两个 map 次数是否相等
     * 3、注意：两个字符串长度必须相等，否则这种方式的判断会有问题
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkPermutationByHash2(String s1,String s2){
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] s1Chars = s1.toCharArray();
        Map<Character, Integer> s1Map = getMap(s1);
        Map<Character, Integer> s2Map = getMap(s2);
        for (char s1Char : s1Chars) {
            if (!s2Map.containsKey(s1Char) || s2Map.get(s1Char) != s1Map.get(s1Char)) {
                return false;
            }
        }
        return true;
    }
    private static Map<Character, Integer> getMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        return map;
    }


    /**
     * 解题思路：排序法
     * 将两个字符串全部从⼩到⼤或者从⼤到⼩排列，然后再逐个位置⽐较
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkPermutationBySort(String s1,String s2){
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);

        return new String(s1Chars).equals(new String(s2Chars));
    }


    /**
     * 解题思路：倒排索引思路
     *
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkPermutationByReverseIndex(String s1,String s2){
        if (s1.length() != s2.length()) {
            return false;
        }


        return false;
    }
}
