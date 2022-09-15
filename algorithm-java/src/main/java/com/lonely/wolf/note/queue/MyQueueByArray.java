package com.lonely.wolf.note.queue;

/**
 * 基于数组实现自定义单向队列。FIFO(first in first out)先进先出
 *
 * 元素入队，tail+1，元素出队，head+1。当 head=tail 表示队列已满，但是此时 head 前面是空的，出现了“假溢出”问题，环形队列可以解决此问题
 *
 * 单向队列容易出现“假溢出问题”
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/26
 * @since jdk1.8
 */
public class MyQueueByArray<E> {
    public static void main(String[] args) {
        MyQueueByArray myQueue = new MyQueueByArray(3);
        System.out.println("队列是否为空：" + myQueue.isEmpty());//输出:true
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        System.out.println("队列是否已满：" + myQueue.isFull());//输出:true
        System.out.println("第1次出队：" + myQueue.dequeue());//输出:1
        System.out.println("第2次出队：" + myQueue.dequeue());//输出:2
        System.out.println("第3次出队：" + myQueue.dequeue());//输出:3
        System.out.println("队列是否为空：" + myQueue.isEmpty());//输出:true
        System.out.println("队列是否已满：" + myQueue.isFull());//输出:true
    }

    private Object[] data;
    private int size;//队列长度

    private int head;//队列头部
    private int tail;//队列尾部


    public MyQueueByArray(int size) {//初始化
        this.size = size;
        data = new Object[size];
        head = -1;
        tail = -1;
    }


    /**
     * tail=size-1 表示队列已满
     * @return
     */
    public boolean isFull(){
        return tail == size - 1;
    }

    /**
     * head=tail表示队列为空
     * @return
     */
    public boolean isEmpty(){
        return head == tail;
    }


    /**
     * 元素入队，tail指针后移一位
     * @param e
     * @return
     */
    public boolean enqueue (E e){
        if (isFull()){
            return false;
        }
        data[++tail] = e;//tail 指针后移
        return true;
    }


    /**
     * 元素出丢
     * @return
     */
    public E dequeue (){
        if (isEmpty()){
            return null;
        }
        E e = (E)data[++head];//出队
        return e;
    }
}
