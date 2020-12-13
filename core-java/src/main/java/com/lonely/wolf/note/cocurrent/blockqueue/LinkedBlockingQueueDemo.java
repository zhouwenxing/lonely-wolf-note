package com.lonely.wolf.note.cocurrent.blockqueue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/3
 * @since jdk1.8
 */
public class LinkedBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue(100);//默认非公平锁实现
        new Thread(new ConsumerThread1(queue)).start();
        Thread.sleep(2000);
        new Thread(new ProcuctThread1(queue)).start();

//        final AtomicInteger count = new AtomicInteger(0);
//        int c = count.getAndIncrement();
//        System.out.println(c);
//        System.out.println(count.get());
    }
}


class ProcuctThread1 extends Thread{
    private LinkedBlockingQueue queue;
    public ProcuctThread1(LinkedBlockingQueue queue) {
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

class ConsumerThread1 extends Thread{
    private LinkedBlockingQueue queue;
    public ConsumerThread1(LinkedBlockingQueue queue) {
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
