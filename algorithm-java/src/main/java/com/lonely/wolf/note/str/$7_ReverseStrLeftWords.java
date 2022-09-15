package com.lonely.wolf.note.str;

/**
 * [剑指Offer】58、左旋转字符串
 * 字符串的左旋转操作是把字符串前⾯的若⼲个字符转移到字符串的尾部。请定义⼀个函数实现字符串左旋转操作的功能。
 *
 * 示例：
 * 输⼊: s = "abcdefg", k = 2  输出: "cdefgab"
 * 输⼊: s = "lrloseumgh", k = 6 输出: "umghlrlose"
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/1/4
 * @since jdk1.8
 */
public class $7_ReverseStrLeftWords {

    public static void main(String[] args) {
        String s1 = "abcdefg";
        System.out.println("subString:" + reverseLeftWorkByJavaApiSubString(s1,2));
        System.out.println("StringBuild:" + reverseLeftWorkByJavaApiStringBuild(s1,2));

        String s2 = "lrloseumgh";
        System.out.println("subString:" + reverseLeftWorkByJavaApiSubString(s2,6));
        System.out.println("StringBuild:" + reverseLeftWorkByJavaApiStringBuild(s2,6));

    }


    /**
     *
     * 解题思路：通过 subString 实现
     *
     * @param s
     * @param k
     * @return
     */
    public static String reverseLeftWorkByJavaApiSubString(String s,int k){
        if (null == s || s.length() == 0 || k <=0){
            return s;
        }
        k = k % s.length();
        if (k == 0){
            return s;
        }
        return s.substring(k) + s.substring(0,k);
    }

    /**
     *
     * 解题思路：通过 StringBuilder 实现
     *
     * @param s
     * @param k
     * @return
     */
    public static String reverseLeftWorkByJavaApiStringBuild(String s,int k){
        if (null == s || s.length() == 0 || k <=0){
            return s;
        }
        k = k % s.length();
        if (k == 0){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=k;i<s.length();i++){//先添加 k 之后元素
            sb.append(s.charAt(i));
        }

        for (int i=0;i<k;i++){//添加 0 到 k 元素
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    /**
     *
     * 解题思路：仅通过 charAt 和 String 实现
     *
     * 其实也可以通过 char 数组实现
     *
     * @param s
     * @param k
     * @return
     */
    public static String reverseLeftWorkByOnlyChatAt(String s,int k){
        if (null == s || s.length() == 0 || k <=0){
            return s;
        }
        k = k % s.length();
        if (k == 0){
            return s;
        }
        String resultStr = "";
        for (int i=k;i<s.length();i++){//先添加 k 之后元素
            resultStr += s.charAt(i);
        }

        for (int i=0;i<k;i++){//添加 0 到 k 元素
            resultStr += s.charAt(i);;
        }
        return resultStr;
    }
}
