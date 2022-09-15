package com.lonely.wolf.note.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 225
 * 请你仅使⽤两个队列实现⼀个后⼊先出（LIFO）的栈，并⽀持普通栈的全部四种操作（push、top、pop 和 empty）:
 *
 * void push(int x) 将元素 x 压⼊栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * 注意：
 * 1、你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 2、你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 *
 * 解题思路：
 * 1、先把元素 1 存入 secondQueue
 * 2、此时 mainQueue 为空，不进行操作，将 mainQueue 和 secondQueue 交换位置
 * 3、此时 mainQueue=1,secondQueue=null
 * 4、把元素 2 存入 secondQueue
 * 5、此时 mainQueue 不为空，将 mainQueue 元素 入队 secondQueue，此时 secondQueue=2,1（此时1 和 2已经换了位置）
 * 6、将 mainQueue 和 secondQueue 交换位置，此时 mainQueue=2，1,secondQueue=null
 * 7、继续重复上面操作
 * 8、出队只需要操作 mainQueue
 *
 * 拓展：用一个队列其实也能实现
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/26
 * @since jdk1.8
 */
public class MyStackByTwoQueue {
    public static void main(String[] args) {
        MyStackByTwoQueue queue = new MyStackByTwoQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
    }

    private Queue<Integer> mainQueue = new LinkedList<>();
    private Queue<Integer> secondQueue = new LinkedList<>();


    public void push(int e){
        secondQueue.add(e);
        if (!mainQueue.isEmpty()){
            secondQueue.add(mainQueue.poll());
        }
        //交换连个 queue，此时新加入的元素 e 即为 mainQueue 的头部元素
        Queue temp = mainQueue;
        mainQueue = secondQueue;
        secondQueue = temp;
    }


    public int top(){
        return mainQueue.peek();
    }

    public int pop(){
        return mainQueue.poll();
    }

    public boolean empty() {
        return mainQueue.isEmpty();
    }
}
