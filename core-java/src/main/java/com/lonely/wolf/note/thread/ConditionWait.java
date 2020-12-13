package com.lonely.wolf.note.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/2/6
 * @since jdk1.8
 */
public class ConditionWait implements Runnable{
    private Lock lock;
    private Condition condition;


    public ConditionWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }



    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("conditionWait-begin");
            condition.await();
            System.out.println("conditionWait-end");
        }catch (Exception e){

        }finally {
            lock.unlock();

        }


    }
}
