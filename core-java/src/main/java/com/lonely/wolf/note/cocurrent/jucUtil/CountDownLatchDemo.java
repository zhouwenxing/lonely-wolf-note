package com.lonely.wolf.note.cocurrent.jucUtil;

import java.util.concurrent.CountDownLatch;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/6/26
 * @since jdk1.8
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(()->{
            System.out.println("----------");
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.out.println("==========");
    }
}
