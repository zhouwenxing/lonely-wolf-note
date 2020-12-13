package com.lonely.wolf.note.cocurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/6/25
 * @since jdk1.8
 */
public class LockConditionDemo {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(new ConditionAwait(lock,condition)).start();
        Thread.sleep(1000);
        new Thread(new ConditionSingal(lock,condition)).start();
    }
}

class ConditionAwait implements Runnable{
    private Lock lock;
    private Condition condition;

    public ConditionAwait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        System.out.println("await begin");
        try {
            lock.lock();
            condition.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        System.out.println("await end");
    }
}

class ConditionSingal implements Runnable{
    private Lock lock;
    private Condition condition;

    public ConditionSingal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        System.out.println("signal begin");
        try {
            lock.lock();
            condition.signal();
        }finally {
            lock.unlock();
        }
        System.out.println("signal end");
    }
}
