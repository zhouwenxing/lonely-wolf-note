package com.lonely.wolf.note.cocurrent.blockqueue;

import com.lonely.wolf.note.blockqueue.model.MyElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/2
 * @since jdk1.8
 */
public class DelayQueueDemo {
    public static void main(String[] args) {
        List<MyElement> list = new ArrayList<>();
        for (int i=1;i<=5;i++){
            MyElement myElement = new MyElement(i,i*1000);
            list.add(myElement);
        }
        DelayQueue delayQueue = new DelayQueue(list);

        while (true){
            try {
                MyElement myElement = (MyElement) delayQueue.take();
                System.out.println(myElement.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
