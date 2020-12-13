package com.lonely.wolf.note.cocurrent.jucUtil;

import java.util.concurrent.CyclicBarrier;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/6/27
 * @since jdk1.8
 */
public class CyclicbarrierDemo {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    public static void main(String[] args) {
        new Thread(()-> {
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("我是线程t1");
        },"t1").start();
        new Thread(()-> {
            try {
                cyclicBarrier.reset();
                cyclicBarrier.await();
//                cyclicBarrier.reset();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("我是线程t2");
        },"t2").start();
        new Thread(()-> {
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("我是线程t3");
        },"t3").start();

        System.out.println("主线程==end");
    }
}
