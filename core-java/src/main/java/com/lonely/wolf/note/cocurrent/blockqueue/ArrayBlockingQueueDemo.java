package com.lonely.wolf.note.cocurrent.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/2
 * @since jdk1.8
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(100);//默认非公平锁实现
        new Thread(new ConsumerThread(queue)).start();
        Thread.sleep(2000);
        new Thread(new ProcuctThread(queue)).start();
    }
}

class ProcuctThread extends Thread{
    private ArrayBlockingQueue queue;
    public ProcuctThread(ArrayBlockingQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
       for (int i=0;i<100;i++){
           try {
               queue.put(i);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}

class ConsumerThread extends Thread{
    private ArrayBlockingQueue queue;
    public ConsumerThread(ArrayBlockingQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true){
            try {
                int a = (int)queue.take();
                System.out.println("消费：" + a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

