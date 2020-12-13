package com.lonely.wolf.note.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/8
 * @since jdk1.8
 */
public class MyItem {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i=0;i<list.size();i++){
            int a = list.get(i);
            System.out.println(a);
        }
    }
}
