package com.lonely.wolf.note.cocurrent.blockqueue;

import java.util.concurrent.SynchronousQueue;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/14
 * @since jdk1.8
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue queue = new SynchronousQueue(true);
        new Thread(()->{
            try {
                queue.take();
//                queue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();

        new Thread(()->{
            try {
                queue.put(2);
//                queue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t3").start();
        System.out.println("end");
//        System.out.println(queue.size());


    }
}
