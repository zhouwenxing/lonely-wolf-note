package com.lonely.wolf.note.thread.baseapi;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/6/18
 * @since jdk1.8
 */
public class CurrentThreadAndThis {

    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        myThread.start();
//        Thread t1 = new Thread(myThread,"t1");
//        t1.start();
        int a = Integer.MAX_VALUE;
        a = a+1;
        if (a<0){
            System.out.println(a);
        }

    }
}


