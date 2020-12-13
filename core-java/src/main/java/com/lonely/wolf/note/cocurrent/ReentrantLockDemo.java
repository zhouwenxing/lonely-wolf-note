package com.lonely.wolf.note.cocurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/6/21
 * @since jdk1.8
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println(1);
        }finally {
            lock.unlock();
        }
    }
}
