package com.lonely.wolf.note.exercise.homework3;

/**
 * 讲义2.2 第5题 LeetCode.557. 反转字符串中的单词 III
 * 要反转字符串里的单词时，下面是讲义里用双指针的一种实现，但是执行的时候发现输出的序列与原始序列一样
 * 请你找出问题所在，并修改好。
 * 要求：
 * 1.只能在如下代码基础上修改，并且修改的代码数量不超过10行
 * 2.请保证提交的代码能执行，不能执行或者执行结果不对，视为0分
 * 3.最晚提交时间：2022年1月3日晚12点，过期提交作废
 * 4.请将homework.task3下的题目做完后一起打包发到荣荣邮箱，包名必须有你的编号（参考编号列表），如果不按规定找不到你，视为0分
 * 5.出题不易，一起都为了你的学习，请不要随便外传题目
 */
public class FindError {
    public static void main(String[] args) {
      String str="Let's take LeetCode contest";
        System.out.println(reverseWordsError(str));
    }

    public static String reverseWordsError(String s) {
        int length = s.length();
        char[] charArray = s.toCharArray();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && charArray[i] != ' ') {
                i++;
            }

            int left = start, right = i - 1;
            swap(charArray,left,right);
//            while (left < right) {
//                swap(charArray[left], charArray[right]);//基础类型不能通过这种方式交换
//                left++;
//                right--;
//            }
            while (i < length && charArray[i] == ' ') {
                i++;
            }
        }
        return String.valueOf(charArray);
    }

//    public static void swap(char a ,char b){
//        char c=a;
//        a=b;
//        b=c;
//    }

    public static void swap(char[] chars,int left,int right){
        while (left < right){
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }
}
