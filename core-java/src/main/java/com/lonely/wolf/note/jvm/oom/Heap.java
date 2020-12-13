package com.lonely.wolf.note.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆-->OOM
 * @author zwx
 * @version 1.0
 * @date 2020/8/5
 * @since jdk1.8
 */
public class Heap {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        while (true){
            list.add(99999);
        }
    }
}
