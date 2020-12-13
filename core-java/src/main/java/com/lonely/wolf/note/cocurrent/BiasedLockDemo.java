package com.lonely.wolf.note.cocurrent;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 偏向锁的批量撤销
 * @author zwx
 * @version 1.0
 * @date 2020/5/26
 * @since jdk1.8
 */
public class BiasedLockDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);//默认延迟4s才会开启偏向锁，休眠5s确保开启偏向锁
        List<User> list = new ArrayList<>();
        new Thread(()->{
            for (int i=0;i<20;i++){
                User user = new User();//这里必须要new不同的对象，不能共用同一个对象
                synchronized (user){
                    list.add(user);
                    System.out.println("t1线程第" + (i+1) + "对象:" + ClassLayout.parseInstance(user).toPrintable());
                }
            }
        },"t1").start();
        try {
            Thread.sleep(10000);//确保t1创建对象完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            for (int j=0;j<20;j++){
                User user = list.get(j);
                synchronized (user){
                    System.out.println("t2线程第" + (j+1) + "对象:" + ClassLayout.parseInstance(user).toPrintable());
                }
            }
        },"t2").start();
    }
}
