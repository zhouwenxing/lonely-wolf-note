package com.lonely.wolf.note.happensbefore;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/2/4
 * @since jdk1.8
 */
public class JoinRule {

    static int x = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1  = new Thread(()->{
            x=100;
        });
        x = 10;
        t1.start();
        t1.join();
        System.out.println(x);//x为100，join之后t1修改了x后，x对主线程可见
    }
}
