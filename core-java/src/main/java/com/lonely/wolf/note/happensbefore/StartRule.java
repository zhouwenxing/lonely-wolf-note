package com.lonely.wolf.note.happensbefore;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/2/4
 * @since jdk1.8
 */
public class StartRule {
    static int x = 0;

    public static void main(String[] args) {
        Thread t1  = new Thread(()->{
            //主线程修改x的值对t1可见
            System.out.println(x);//x=10
        });
        x = 10;//1
        t1.start();//2
    }
}
