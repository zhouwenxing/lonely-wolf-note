package com.lonely.wolf.note.exercise.homework3;

/**
 * 在咕泡有很多小姐姐,她们给我们的学习增加了很多快乐，
 * 她们每个人都有一个花名，例如文文、田田、颖子、荣荣、媛媛、梦晴、书昀等等
 * 假定每个人的名字长度不小于5个字母，为了压缩存储，我们可以将相同字的后一个用"~"来表示。
 * 例如，wenwen，rongrong就用wen~,rong~来表示，而yingzi、shuyun等都保持不变
 * 名字之间以空格隔开，现在请你设计一个算法实现上述压缩功能。
 * 要求：
 * 1.功能在compressName()中实现，你可以将String 转换后保存到一个数组里，除此之外不得再申请O(n)级别的空间
 * 2.请保证提交的代码能执行，不能执行或者执行结果不对，视为0分
 * 3.最晚提交时间：2022年1月3日晚12点，过期提交作废
 * 4.请将homework.task3下的题目做完后一起打包发到荣荣邮箱，包名必须有你的编号（参考编号列表），如果不按规定找不到你，视为0分
 * 5.出题不易，一起都为了你的学习，请不要随便外传题目
 */
public class GuPaoName {

    public static void main(String[] args) {
//
        String str1 = "wenwen tiantian yingzi rongrong";

        //这里应该输出"wen~ tian~ yingzi rong~"
        System.out.println(compressName(str1));

        String str2 = "yingzi chengzi ";
//        这里仍然输出"yingzi chengzi "
        System.out.println(compressName(str2));
    }

    /**
     * 请在这里实现功能
     *
     * @param str
     * @return
     */
    public static String compressName(String str) {
        if (null == str || "".equals(str)){
            return "";
        }
        String[] arr = str.split("\\s+");
        for (int i = 0;i < arr.length;i++){
            String s = arr[i];
            int half = s.length() / 2;
            if (s.length() <= 1 || s.length() % 2 == 1){//长度小于等于1或者长度为奇数则不可能为叠词
                continue;
            }
            int m = 0;
            char compareChar = s.charAt(m++);//这里 m++ 下面while循环就避免了自己和自己比较
            int start = 0;//比较起始点
            int end = 0;//比较结束点
            while (m < s.length()){
                if (m > half){//超过一半则不用比较了
                    break;
                }
                if (compareChar == s.charAt(m) && m == half){//相等而且到了一半位置，小于一半相等也可以无视
                    end = m - 1;
                    while (start <= end){
                        if (s.charAt(start) == s.charAt(m)){
                            start++;
                            m++;
                            continue;
                        }
                        break;//发现一个不相等，则跳出循环
                    }
                    //到这里说明完美说明当前昵称是叠词
                    arr[i] = s.substring(0,half) + "~";
                }
                m++;
            }
        }
        return String.join(" ",arr);
    }
}
