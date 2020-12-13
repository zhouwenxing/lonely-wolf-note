package com.lonely.wolf.note.cocurrent.jucUtil;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/6/27
 * @since jdk1.8
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(2);
        for(int i=1;i<=5;i++){
            new Car(i,semaphore).start();
        }
    }
}

class Car extends Thread{
    private int num;
    private Semaphore semaphore;

    public Car(int num, Semaphore semaphore) {
        this.num = num;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();//获取一个许可
            System.out.println("第"+num+"辆车进来了");

            TimeUnit.SECONDS.sleep(2);
            System.out.println("第"+num+"辆车出去了");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
