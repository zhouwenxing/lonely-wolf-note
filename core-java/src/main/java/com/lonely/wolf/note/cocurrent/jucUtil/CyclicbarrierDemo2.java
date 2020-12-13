package com.lonely.wolf.note.cocurrent.jucUtil;

import java.util.concurrent.CyclicBarrier;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/6/27
 * @since jdk1.8
 */
public class CyclicbarrierDemo2 {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2,new MyThread());
    public static void main(String[] args) {
//        new Thread(()-> {
//            try {
//                cyclicBarrier.await();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            System.out.println("我是线程t1");
//        },"t1").start();
//        new Thread(()-> {
//            try {
//                cyclicBarrier.await();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            System.out.println("我是线程t2");
//        },"t2").start();

        System.out.println("主线程==end");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("do something");
        }
    }
}
