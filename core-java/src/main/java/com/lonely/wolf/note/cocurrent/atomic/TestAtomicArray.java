package com.lonely.wolf.note.cocurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/19
 * @since jdk1.8
 */
public class TestAtomicArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);
        atomicIntegerArray.compareAndSet(1,2,8);
        System.out.println(arr[1]);//原数组的值没被改变，还是2
        System.out.println(atomicIntegerArray.get(1));//atomicIntegerArray值被改变成8
    }
}
