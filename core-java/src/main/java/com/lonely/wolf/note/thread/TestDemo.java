package com.lonely.wolf.note.thread;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/2/4
 * @since jdk1.8
 */
public class TestDemo {
    public volatile static boolean stop = false;


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            int i = 0;
            while (!stop){
                i++;
            }
        });
        t1.start();
        Thread.sleep(1000);
        stop = true;
    }
}
