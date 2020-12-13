package com.lonely.wolf.note.thread;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/2/15
 * @since jdk1.8
 */
public class ThreadStopDemo extends Thread{

    private int i = 0;

    @Override
    public void run() {
        try {
            while (true){
                i++;
                System.out.println("i=" + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
