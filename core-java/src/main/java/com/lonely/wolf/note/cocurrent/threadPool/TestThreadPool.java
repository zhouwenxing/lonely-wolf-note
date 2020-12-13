package com.lonely.wolf.note.cocurrent.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/21
 * @since jdk1.8
 */
public class TestThreadPool {
    public static void main(String[] args) {
        //FixedThreadPool - 创建固定线程数
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i=0;i<10;i++){
            fixedThreadPool.execute(()-> {
                System.out.println("线程名：" + Thread.currentThread().getName());
            });
        }
        fixedThreadPool.shutdown();

          //CachedThreadPool - 用到线程才创建
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i=0;i<9;i++){
            try {
                Thread.sleep(i * 10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(()-> {
                System.out.println("线程名：" + Thread.currentThread().getName());
            });
        }
        cachedThreadPool.shutdown();

        //SingleThreadExecutor - 只有一个线程的执行器
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i=0;i<9;i++){
            singleThreadExecutor.execute(()-> {
                System.out.println("线程名：" + Thread.currentThread().getName());
            });
        }
        singleThreadExecutor.shutdown();


        //ScheduledThreadPool
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
        for (int i=0;i<3;i++){
            final long t1 = System.currentTimeMillis();
            scheduledThreadPool.schedule(()->{
                long t2 = System.currentTimeMillis();
                System.out.println(t2-t1);
                System.out.println("线程名：" + Thread.currentThread().getName());
            },5, TimeUnit.SECONDS);
//            scheduledThreadPool.execute(()->{
//                System.out.println("线程名：" + Thread.currentThread().getName());
//            });
        }
        scheduledThreadPool.shutdown();
    }
}
