package com.lonely.wolf.note.cocurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/6/24
 * @since jdk1.8
 */
public class LockParkInterrputDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            int i = 0;
            while (true){
               if(i == 0){
                   LockSupport.park();
                   System.out.println(Thread.currentThread().isInterrupted());
                   LockSupport.park();
                   LockSupport.park();
                   System.out.println("如果走到这里就说明park不生效了");
               }
               i++;
               if(i == Integer.MAX_VALUE){
                   break;
               }
            }
        });
        t1.start();
        Thread.sleep(1000);//确保t1被park()之后再中断
        t1.interrupt();
        System.out.println("end");
    }
}
