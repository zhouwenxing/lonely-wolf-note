package com.lonely.wolf.note.thread;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/2/15
 * @since jdk1.8
 */
public class TestThreadStop {

    public static void main(String[] args) {
        try {
            ThreadStopDemo threadStopDemo = new ThreadStopDemo();
            threadStopDemo.start();
            Thread.sleep(5000);
            threadStopDemo.stop();
            System.out.println(222222);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
