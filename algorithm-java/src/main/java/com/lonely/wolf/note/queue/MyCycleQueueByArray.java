package com.lonely.wolf.note.queue;

/**
 *
 *
 * 初始化队列时: head = tail = 0
 * 队列满时： ( tail +1 ) % maxSize == head (其中 maxSize为初始化队列时，设置的队列最⼤元素个数)
 *
 * 环形队列不能使⽤ tail = maxSize-1 作为判断队满的条件，因使⽤环形队列⽅式实现，当第⼀次队满时，tail = maxSize -1，
 * 执⾏出队操作后原队头位置空出，此时继续执⾏⼊队操作，则 tail 向后移动⼀个位置，则 tail = 0，
 * ⽽此时队列也是已满状态。所以只要 tail 向前移动⼀个位置就等于 head 时，才是队满的情况
 *
 * tail 指针指向最后⼀个节点的后⼀个元素，即会占⽤⼀个位置⽤来表示队列已满。比如当 data[0] 插入元素时，tail 会移动到 data[1]，此时 data[1] 并没有元素
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/26
 * @since jdk1.8
 */
public class MyCycleQueueByArray<E> {

    public static void main(String[] args) {
        MyCycleQueueByArray cycleQueue = new MyCycleQueueByArray(3);
        System.out.println("循环队列是否为空：" + cycleQueue.isEmpty());//输出:true
        System.out.println("1是否入队成功：" + cycleQueue.enqueue(1));//输出:true
        System.out.println("2是否入队成功：" + cycleQueue.enqueue(2));//输出:true
        System.out.println("3是否入队成功：" + cycleQueue.enqueue(3));//输出:false
        System.out.println("循环队列是否已满：" + cycleQueue.isFull());//输出:true
        System.out.println("第1次出队：" + cycleQueue.dequeue());//输出:1
        System.out.println("第2次出队：" + cycleQueue.dequeue());//输出:2
        System.out.println("第3次出队：" + cycleQueue.dequeue());//输出:null，因为 3 入队失败
        System.out.println("循环队列是否为空：" + cycleQueue.isEmpty());//输出:true
        System.out.println("循环队列是否已满：" + cycleQueue.isFull());//输出:false
    }

    private Object[] data;
    private int size;

    private int head;//队列头部
    private int tail;//队列尾部


    public MyCycleQueueByArray(int size) {
        this.size = size;
        data = new Object[size];
        head = 0;
        tail = 0;
    }

    public boolean isFull(){
        return (tail + 1) % size == head;
    }

    public boolean isEmpty(){
        return head == tail;
    }


    /**
     * 入队
     * @param e
     * @return
     */
    public boolean enqueue (E e){
        if (isFull()){
            return false;
        }
        data[tail] = e;
        tail =  (tail + 1) % size;//注意这里不能直接 tail++，否则无法循环使用
        return true;
    }


    /**
     * 出队
     * @return
     */
    public E dequeue (){
        if (isEmpty()){
            return null;
        }
        E e = (E)data[head];
        head =  (head + 1) % size;//head 也同样不能直接 head++
        return e;
    }
}
