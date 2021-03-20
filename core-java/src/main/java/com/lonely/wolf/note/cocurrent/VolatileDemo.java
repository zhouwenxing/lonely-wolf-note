package com.lonely.wolf.note.cocurrent;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/5/24
 * @since jdk1.8
 */
public class VolatileDemo {
    public static boolean finishFlag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (!finishFlag){
            }
            System.out.println("end");
        },"t1").start();
        Thread.sleep(1000);//确保t1先进入while循环后主线程才修改finishFlag
        finishFlag = true;
    }
}
