package com.lonely.wolf.note.cocurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/19
 * @since jdk1.8
 */
public class TestAtomicBasicData {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(8);
        System.out.println("初始化:" + atomicInteger);//8
        atomicInteger.compareAndSet(8,10);
        System.out.println("CAS后:" + atomicInteger);//10
        System.out.println(atomicInteger.getAndIncrement());//自增1，返回自增前的值10
        System.out.println("自增后：" + atomicInteger);//11
        System.out.println(atomicInteger.getAndDecrement());//11
        System.out.println("自减后：" + atomicInteger);//10
    }
}
