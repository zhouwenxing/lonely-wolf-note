package com.lonely.wolf.note.cocurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/6/16
 * @since jdk1.8
 */
public class LockDemo {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(()->{
            test(lock);
        },"t1").start();

        new Thread(()->{
            test(lock);
        },"t2").start();

    }


    static void test(Lock lock){
        try {
            lock.lock();
            lock.lockInterruptibly();
            while (true){
                System.out.println(111);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
