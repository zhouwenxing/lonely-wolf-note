package com.lonely.wolf.note.thread;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/2/4
 * @since jdk1.8
 */
public class ThreadA extends Thread{
    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("start ThreadA");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end ThreadA");
        }
    }
}
