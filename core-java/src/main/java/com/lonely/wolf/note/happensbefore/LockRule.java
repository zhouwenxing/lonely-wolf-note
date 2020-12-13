package com.lonely.wolf.note.happensbefore;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/2/4
 * @since jdk1.8
 */
public class LockRule {
    int x = 0;

    public void demo(){
        synchronized (this){//两个线程同时访问，相互修改的值均对对方可见
            x++;
        }
    }
}
