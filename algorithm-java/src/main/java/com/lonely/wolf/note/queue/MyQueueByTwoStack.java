package com.lonely.wolf.note.queue;

import java.util.Stack;

/**
 * LeetCode 232
 * 请你仅使⽤两个栈实现先⼊先出队列。队列应当⽀持⼀般队列⽀持的所有操作（push、pop、peek、empty）：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 * 说明：
 * 你只能使⽤标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使⽤的语⾔也许不⽀持栈。你可以使⽤ list 或者 deque（双端队列）来模拟⼀个栈，只要是标准的栈操作即可。
 *
 * 解题思路
 * 将⼀个栈当作输⼊栈，⽤于压⼊ push 传⼊的数据；另⼀个栈当作输出栈，⽤于 pop 和 peek 操作。
 * 每次 pop 或 peek 时，若输出栈为空则将输⼊栈的全部数据依次弹出并压⼊输出栈，
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/26
 * @since jdk1.8
 */
public class MyQueueByTwoStack<Integer> {
    public static void main(String[] args) {

    }

    private Stack<Integer> inStack;//输入栈
    private Stack<Integer> outStack;//输出栈

    /**
     * 即入队：enqueue 操作
     * @param e
     */
    public void push(Integer e){
        inStack.push(e);//压入输入栈
    }


    /**
     * 查看并移除队列头部元素，即：出队 dequeue 操作
     * @return
     */
    public Integer pop(){
        if (!outStack.isEmpty()){//输出栈不为空则直接出栈
            return outStack.pop();
        }
        while (!inStack.isEmpty()){//输出栈为空，则检查输入栈
            outStack.push(inStack.pop());//输入栈不为空，则将其压入输出栈
        }
        if (!outStack.isEmpty()){//再次检查输出栈是否有元素出栈
            return outStack.pop();
        }
        return null;
    }


    /**
     * 查看队列头部元素，相比较 pop，这里只查看元素，并不移除元素
     **/
    public Integer peek(){
        if (!outStack.isEmpty()){
            return outStack.peek();
        }
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        if (!outStack.isEmpty()){
            return outStack.peek();
        }
        return null;
    }


    /**
     * 队列是否为空
     * @return
     */
    public boolean empty(){
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
