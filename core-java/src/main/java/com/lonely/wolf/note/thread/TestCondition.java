package com.lonely.wolf.note.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/2/6
 * @since jdk1.8
 */
public class TestCondition {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(new ConditionWait(lock,condition)).start();
        new Thread(new ConditionNotify(lock,condition)).start();
    }
}
