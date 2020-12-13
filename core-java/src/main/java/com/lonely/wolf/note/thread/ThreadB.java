package com.lonely.wolf.note.thread;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/2/4
 * @since jdk1.8
 */
public class ThreadB extends Thread {

    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("start ThreadB");
            lock.notify();
            System.out.println("end ThreadB");
        }
    }
}
