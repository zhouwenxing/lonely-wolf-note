package com.lonely.wolf.note.stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 括号匹配相关题目
 */
public class $1_BracketsMatch {

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";
        System.out.println(isValidBrackets(s1));
        System.out.println(isValidBrackets(s2));
        System.out.println(isValidBrackets(s3));
        System.out.println(isValidBrackets(s4));
        System.out.println(isValidBrackets(s5));

    }



    /**
     * leetcode 20
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *有效字符串需满足：
     * (1)左括号必须用相同类型的右括号闭合。
     * (2)左括号必须以正确的顺序闭合。
     *
     * 示例：
     * 输入：s = "()"  输出：true
     * 输入：s = "()[]{}" 输出：true
     * 输入：s = "(]" 输出：false
     * 输入：s = "([)]" 输出：false
     * 输入：s = "{[]}" 输出：true
     *
     * @param s
     * @return
     */
    public static boolean isValidBrackets(String s){
        if (null == s || s.length() == 0){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        //配对括号放入 map 可以省去后面的大量 if
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);//左括号入栈
            }else{
                if (stack.isEmpty() || map.get(c) != stack.peek()){
                    return false;
                }
                stack.pop();//配对成功则出栈
            }
        }
        return stack.isEmpty();
    }


    /**
     * LeetCode 856 括号的分数
     * 给定一个平衡括号字符串 s，按下述规则计算该字符串的分数：
     * 1. () 得 1 分。
     * 2. AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
     * 3. (A) 得 2 * A 分，其中 A 是平衡括号字符串。
     * 注意：
     * 1. s 是平衡括号字符串，且只含有 ( 和 ) 。
     * 2. 2 <= s.length <= 50
     *
     * 示例 1：
     * 输入： "()"  输出： 1
     *
     * 示例 2：
     * 输入： "(())" 输出： 2
     *
     * 示例 3：
     * 输入： "()()"   输出： 2
     *
     * 示例 4：
     * 输入： "(()(()))"  输出： 6
     *
     * @param s
     * @return
     */
    public static boolean scoreOfParentheses(String s){

        return false;
    }
}
