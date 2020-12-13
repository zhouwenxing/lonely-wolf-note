package com.lonely.wolf.note.cocurrent;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/5/23
 * @since jdk1.8
 */
public class SynchronizedDemo {

    public synchronized void test(){
        System.out.println("修饰实例方法");
    }

    public static synchronized void test2(){
        System.out.println("修饰静态方法");
    }

    public void test3(){
        synchronized (this){
            System.out.println("修饰代码块");
        }
    }

    public static void main(String[] args) {

    }


}
