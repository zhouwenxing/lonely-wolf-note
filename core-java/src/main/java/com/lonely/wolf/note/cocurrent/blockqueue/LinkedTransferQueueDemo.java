package com.lonely.wolf.note.cocurrent.blockqueue;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/18
 * @since jdk1.8
 */
public class LinkedTransferQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue queue = new LinkedTransferQueue();
//        queue.put(3);
//        queue.put(4);
//        queue.put(5);
//        queue.take();
//        queue.take();
//        queue.put(1);
//        queue.put(2);
//        queue.take();
//        queue.take();
        new Thread(()->{
            try {
                queue.take();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            try {
                queue.take();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();

        new Thread(()->{
            try {
                queue.put(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t3").start();

        new Thread(()->{
            try {
                queue.put(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t4").start();
    }
}
