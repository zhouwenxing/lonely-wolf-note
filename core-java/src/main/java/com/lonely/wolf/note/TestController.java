package com.lonely.wolf.note;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/6/8
 * @since jdk1.8
 */
public class TestController {


    public static void main(String[] args) {
        List<Integer> list = TestController.initList(10);//初始化一个集合
        int n = 2;//需要寻找的号码
        System.out.println(findList(list,n));//输出最后剩余的号码
    }
    public static Integer findList(List<Integer> list ,int n) {
        for (;;){
            for (int j=0;j<n-1;j++){//跳过的数据放到尾部继续循环
                list.add(list.get(j));
            }
            for (int i=n-1;i>=0;i--){
                list.remove(i);
            }
            if (list.size() == 1){//集合只剩下最后一个数则返回
                return list.get(0);
            }
        }
    }


    public static List<Integer> initList(int m) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<m;i++){
            list.add(i + 1);
        }
        return list;
    }





}
