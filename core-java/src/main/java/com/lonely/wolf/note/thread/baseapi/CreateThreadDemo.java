package com.lonely.wolf.note.thread.baseapi;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/6/16
 * @since jdk1.8
 */
public class CreateThreadDemo{
//    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        myThread.start();
//    }

//    public static void main(String[] args) {
//        MyThread1 myThread1 = new MyThread1();
//        Thread thread = new Thread(myThread1);
//        thread.start();
//    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);

            }
        },"t1");
        t1.start();

        new Thread(()->{
            System.out.println("我是t2");
        },"t2").start();
    }

}
