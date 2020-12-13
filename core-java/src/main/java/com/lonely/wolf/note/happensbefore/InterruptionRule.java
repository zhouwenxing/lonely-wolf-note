package com.lonely.wolf.note.happensbefore;

/**
 * 线程中断规则（Thread Interruption Rule）：
 * 对线程interrupt()方法的调用先行发生于被中断线程的代码检测到中断事件的发生，
 * 我们可以通过Thread.interrupted()方法检测到是否有中断发生
 * @author zwx
 * @version 1.0
 * @date 2020/5/24
 * @since jdk1.8
 */
public class InterruptionRule {

    public static void main(String[] args) throws InterruptedException {
        Thread t1  = new Thread(()->{
            System.out.println(Thread.interrupted());
        });
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
    }

}
