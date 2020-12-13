package com.lonely.wolf.note.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/2/6
 * @since jdk1.8
 */
public class ConditionNotify implements Runnable {

    private Lock lock;
    private Condition condition;


    public ConditionNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            System.out.println("conditionNotify-begin");
            lock.lock();
            condition.signal();
            System.out.println("conditionNotify-end");
        }catch (Exception e){

        }finally {
            lock.unlock();
        }


    }
}
