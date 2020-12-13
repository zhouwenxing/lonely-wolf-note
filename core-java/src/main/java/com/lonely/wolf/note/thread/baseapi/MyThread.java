package com.lonely.wolf.note.thread.baseapi;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/6/17
 * @since jdk1.8
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());//t1
        System.out.println(this.getName());//Thread-0
    }
}
