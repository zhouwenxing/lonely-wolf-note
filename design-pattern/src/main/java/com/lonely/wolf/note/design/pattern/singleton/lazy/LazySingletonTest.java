package com.lonely.wolf.note.design.pattern.singleton.lazy;

import com.lonely.wolf.note.design.pattern.singleton.ExectorThread;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/20
 * @since jdk1.8
 */
public class LazySingletonTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());

        t1.start();
        t2.start();

        System.out.println("==================end===========");
    }
}
