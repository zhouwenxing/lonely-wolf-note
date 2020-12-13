package com.lonely.wolf.note.cocurrent;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/5/23
 * @since jdk1.8
 */
public class TestSynchronized {
    private static int count;

    public synchronized static void increment(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;

    }

    public static void main(String[] args) throws InterruptedException {
//        for (int i=0;i<1000;i++){
//            new Thread(()->TestSynchronized.increment()).start();
//        }
        Thread.sleep(3000);
        System.out.println("结果：" + count);
    }
}
