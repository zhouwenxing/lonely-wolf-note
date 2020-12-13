package com.lonely.wolf.note.cocurrent.blockqueue;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/3
 * @since jdk1.8
 */
public class PriorityBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
//        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue(100);//默认非公平锁实现
//        new Thread(new ConsumerThread2(queue)).start();
//        Thread.sleep(2000);
//        new Thread(new ProcuctThread2(queue)).start();
//        int n = 9;
//        int half = (n >>> 1) - 1;
//        System.out.println(half);




        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(5);
        list.add(2);
        list.add(7);
        list.add(6);
        list.add(4);
        list.add(1);
        list.add(9);
        list.add(3);
        PriorityBlockingQueue queue = new PriorityBlockingQueue(list);
        queue.offer(4);
        System.out.println(queue.toString());
    }
}

class MySort<E> implements Comparator<E>, Collection<E> {
    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}


class ProcuctThread2 extends Thread{
    private PriorityBlockingQueue queue;
    public ProcuctThread2(PriorityBlockingQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            queue.put(i);
        }
    }
}

class ConsumerThread2 extends Thread {
    private PriorityBlockingQueue queue;

    public ConsumerThread2(PriorityBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int a = (int) queue.take();
                System.out.println("消费：" + a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

