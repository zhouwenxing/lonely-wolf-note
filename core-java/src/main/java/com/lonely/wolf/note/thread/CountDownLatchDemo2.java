package com.lonely.wolf.note.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/2/6
 * @since jdk1.8
 */
public class CountDownLatchDemo2 extends Thread {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        for (int i=0;i<1000;i++){
            new CountDownLatchDemo2().start();
        }
        countDownLatch.countDown();

    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
