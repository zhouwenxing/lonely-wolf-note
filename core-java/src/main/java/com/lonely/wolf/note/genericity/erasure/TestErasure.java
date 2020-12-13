package com.lonely.wolf.note.genericity.erasure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/8
 * @since jdk1.8
 */
public class TestErasure {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<?> list2 = new ArrayList<>();

        System.out.println(list.equals(list1));//true
        System.out.println(list.equals(list2));//true

    }
}
