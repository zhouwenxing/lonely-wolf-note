package com.lonely.wolf.note.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/1/6
 * @since jdk1.8
 */
public class StackClassicApplication {
    public static void main(String[] args) {
//        String s1 = "()";
//        String s2 = "()[]{}";
//        String s3 = "(]";
//        String s4 = "([)]";
//        String s5 = "{[]}";
//        System.out.println(isValid(s1));
//        System.out.println(isValid(s2));
//        System.out.println(isValid(s3));
//        System.out.println(isValid(s4));
//        System.out.println(isValid(s5));

        System.out.println("-----------------------------------------");
        String s11 = "3+2*2";
        String s22 = " 3/2 ";
        String s33 = " 3+5 / 2 ";
        String s44 = "1-1+1";
        String s55 = "3+2*2";
        String s66 = "33+2*2";

        System.out.println(calculateByTwoStack(s11));
        System.out.println(calculateByTwoStack(s22));
        System.out.println(calculateByTwoStack(s33));
        System.out.println(calculateByTwoStack(s44));
        System.out.println(calculateByTwoStack(s55));
        System.out.println(calculateByTwoStack(s66));

        System.out.println("-----------------------------------------");

        System.out.println(calculateOneStack(s11));
        System.out.println(calculateOneStack(s22));
        System.out.println(calculateOneStack(s33));
        System.out.println(calculateOneStack(s44));
        System.out.println(calculateOneStack(s55));
        System.out.println(calculateOneStack(s66));

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
   public static boolean isValid(String s){
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
     * leetcode 227
     * 给你一个有效的字符串表达式 s，请你实现一个基本计算器来计算并返回它的值，整数除法仅保留整数部分。
     * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
     *
     * 示例：
     * 输入：s = "3+2*2" 输出：7
     * 输入：s = " 3/2 " 输出：1
     * 输入：s = " 3+5 / 2 "  输出：5
     *
     * 解题思路：
     * 通过两个栈实现
     *
     * @param s
     * @return
     */
   public static int calculateByTwoStack(String s){
       if (null == s || s.length() == 0){
           return 0;
       }
       Stack<Integer> numStack = new Stack<>();//操作数栈
       Stack<Character> operatorStack = new Stack<>();//运算符栈

       int num = 0;
       for (int i = 0;i<s.length();i++){
           char c = s.charAt(i);
           if (Character.isDigit(c)){//数字
               num = num * 10 + (c - '0');
               if (i == s.length() - 1 || s.charAt(i+1) == ' '){//如果是最后一位或者下一位是空格，需要将数字入栈
                   numStack.push(num);
                   num = 0;
               }
               continue;
           }
           if (c == '+' || c == '-' || c == '*' || c == '/'){
               if (s.charAt(i-1) != ' '){//如果前一位不是空格，那需要将整数入栈
                   numStack.push(num);
                   num = 0;
               }
               if (c == '*' || c == '/'){//如果是乘除法，那么需要将当前运算法栈内的乘除法先计算出来
                   while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')){
                       numStack.push(sum(numStack,operatorStack.pop()));//将计算出的结果再次入栈
                   }
               } else {//如果是加减法，优先级已经是最低，那么当前运算符栈内所有数据都需要被计算掉
                   while (!operatorStack.isEmpty()){
                       numStack.push(sum(numStack,operatorStack.pop()));
                   }
               }
               operatorStack.push(c);
           }
       }
       //最后开始遍历：两个操作数，一个运算符进行计算
       while (!numStack.isEmpty() && !operatorStack.isEmpty()){
           numStack.push(sum(numStack,operatorStack.pop()));//计算结果再次入栈
       }
       return numStack.pop();//最后一定剩余一个结果入栈了
   }

   private static int sum(Stack<Integer> numStack,char operator){
       int num1 = numStack.pop();
       int num2 = numStack.pop();
       int result = 0;
       switch (operator){
           case '+':
               result = num2 + num1;
               break;
           case '-':
               result = num2 - num1;
               break;
           case '*':
               result = num2 * num1;
               break;
           case '/':
               result = num2 / num1;
               break;
           default:
       }
       return result;
   }


    /**
     * leetcode 227
     * 给你一个有效的字符串表达式 s，请你实现一个基本计算器来计算并返回它的值，整数除法仅保留整数部分。
     * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
     *
     * 示例：
     * 输入：s = "3+2*2" 输出：7
     * 输入：s = " 3/2 " 输出：1
     * 输入：s = " 3+5 / 2 "  输出：5
     *
     * 解题思路：
     * 通过一个栈实现
     *
     * @param s
     * @return
     */
    public static int calculateOneStack(String s){
        if (null == s || s.length() == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char preOperator = '+';
        int num = 0;
        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length()-1){//判断数字处理是否已经结束，如果结束需要将数字入栈或者计算结果入栈
                switch (preOperator){
                    case '+':
                        stack.push(num);//加法则直接将数字入栈
                        break;
                    case '-':
                        stack.push(-num);//减法则将负数入栈
                        break;
                    case '*':
                        stack.push(stack.pop() * num);//乘法则需要计算结果入栈
                        break;
                    case '/':
                        stack.push(stack.pop() / num);//除法则需要计算结果入栈
                        break;
                    default:
                }
                preOperator = c;
                num = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()){//最后将栈内所有数据相加即可得到结果
            result+=stack.pop();
        }
        return result;
    }
}
