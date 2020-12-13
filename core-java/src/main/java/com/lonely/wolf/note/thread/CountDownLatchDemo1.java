package com.lonely.wolf.note.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/2/6
 * @since jdk1.8
 */
public class CountDownLatchDemo1 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch coutDownLantch = new CountDownLatch(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1");
                coutDownLantch.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread2");
                coutDownLantch.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread3");
                coutDownLantch.countDown();
            }
        }).start();
        coutDownLantch.await();

    }
}
