package com.lonely.wolf.note.thread;

import java.util.concurrent.Semaphore;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/2/6
 * @since jdk1.8
 */
public class SemaphoraDemo {
    //一般用于限流
    static class Car extends Thread {
        private int num;
        private Semaphore semaphore;

        public Car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();//获取令牌，拿不到则阻塞
                System.out.println("第" + num + "个抢走一个车位");
                Thread.sleep(2000);
                System.out.println("第" + num + "辆车开走了");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i=0;i<10;i++){
            new Car(i,semaphore).start();
        }
    }
}
