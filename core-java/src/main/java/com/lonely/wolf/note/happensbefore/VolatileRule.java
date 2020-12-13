package com.lonely.wolf.note.happensbefore;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/5/24
 * @since jdk1.8
 */
public class VolatileRule {
    private volatile boolean flag = false;
    private int a = 0;

    public void writer(){
        a = 1;//1
        flag = true;//2
        int b = 2;
    }

    public void read(){
        if(flag){//3
            int i = a;//4
        }
    }
}
