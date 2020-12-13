package com.lonely.wolf.note.genericity.wildcard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/8
 * @since jdk1.8
 */
public class Manager<T> extends Employee {
    public static void main(String[] args) {
        List<?> list = new ArrayList<>();
        List<? extends Employee> list1 = new ArrayList<>();
        list = list1;

    }
}
