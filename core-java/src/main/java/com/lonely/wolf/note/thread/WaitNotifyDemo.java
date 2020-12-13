package com.lonely.wolf.note.thread;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/2/4
 * @since jdk1.8
 */
public class WaitNotifyDemo {

    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        ThreadB threadB = new ThreadB(lock);

        threadA.start();
        threadB.start();
    }


}
