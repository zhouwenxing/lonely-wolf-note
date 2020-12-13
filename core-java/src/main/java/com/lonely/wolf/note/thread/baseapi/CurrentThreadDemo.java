package com.lonely.wolf.note.thread.baseapi;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/6/17
 * @since jdk1.8
 */
public class CurrentThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            int i=0;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(Thread.interrupted()){
                System.out.println("我是线程" + Thread.currentThread().getName() + "：" + Thread.interrupted());
            }
        },"t1");
        t1.start();
        t1.interrupt();
        Thread.sleep(1000);
//        System.out.println("我是线程" + Thread.currentThread().getName() + "：" + t1.isInterrupted());
//        System.out.println("我是线程" + Thread.currentThread().getName() + "：" + t1.isInterrupted());
    }
}
