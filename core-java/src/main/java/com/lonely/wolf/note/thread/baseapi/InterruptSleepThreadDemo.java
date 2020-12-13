package com.lonely.wolf.note.thread.baseapi;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/6/18
 * @since jdk1.8
 */
public class InterruptSleepThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());
            }
        },"t1");
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
    }
}
