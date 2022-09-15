package com.lonely.wolf.note.array;

/**
 * 请实现⼀个函数，将⼀个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 *
 * 解题思路是考虑当前存储字符串是可变还是不可变长
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/20
 * @since jdk1.8
 */
public class $6_ReplaceSpace {
    public static void main(String[] args) {
        String result = replaceSpace(new StringBuffer("We Are Happy"));
        System.out.println(result);

        String result2 = replaceSpace(new StringBuffer("I am lonely wolf"));
        System.out.println(result2);

        String result3 = testReplaceSpace2(new StringBuffer("I am lonely wolf"));
        System.out.println(result3);

    }


    /**
     * 替换可变字符串的空格
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str){
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if (c == ' '){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    /**
     * 替换不可变字符串空格
     * 从前往后遍历会大量移动元素，复杂度为O(n^2),所以考虑从后往前遍历
     * 从后往前遍历，得先知道字符串长度，所以需要先遍历一次，找出空格数，得出总长度为：n+空格数*2（n为字符串长度）
     * @param str
     * @return
     */
    public static String replaceSpace2(StringBuffer str){
        int blankNum = 0;
        int oldLength = str.length();
        for (int i=0;i<oldLength;i++){
            char c = str.charAt(i);
            if (c == ' '){
                blankNum++;
            }
        }
        str.setLength(oldLength + blankNum * 2);

        int oldIndex = oldLength - 1;
        int newIndex = str.length() - 1;
        while (oldIndex >=0 && newIndex > oldIndex){
            char c = str.charAt(oldIndex);
            if (c == ' '){
                oldIndex--;
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            }else{
                oldIndex--;
                str.setCharAt(newIndex--,c);
            }
        }
        return str.toString();
    }


    /**----------------------------------------------------以下为复盘练习使用方法---------------------------------------------*/


    public static String testReplaceSpace2(StringBuffer str){
        if (null == str || str.length() == 0){
            return "";
        }
        int oldLength = str.length();
        int blankNum = 0;
        for (int i=0;i<oldLength;i++){
            if (str.charAt(i) == ' '){
                blankNum++;
            }
        }
        str.setLength(oldLength + blankNum * 2);
        int newIndex = str.length() - 1;
        for (int i=oldLength-1;i>=0;i--){
            if (str.charAt(i) == ' '){
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            }else{
                str.setCharAt(newIndex--,str.charAt(i));
            }
        }
        return str.toString();
    }
}
