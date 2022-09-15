package com.lonely.wolf.note.stack;

/**
 * 基于链表实现自定义栈
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/24
 * @since jdk1.8
 */
public class MyStackByList<E> {
    public static void main(String[] args) {
        MyStackByList stack = new MyStackByList();
        stack.push(1);
        System.out.println("stack有效元素个数：" + stack.size);
        System.out.println("查看栈顶元素：" + stack.peek());
        System.out.println("栈是否为空：" + stack.isEmpty());
        System.out.println("弹出栈顶元素：" + stack.pop());
        System.out.println("栈是否为空：" + stack.isEmpty());
        stack.push(2);
        stack.push(3);
        System.out.println("stack有效元素个数：" + stack.size);
        System.out.println("弹出栈顶元素：" + stack.pop());
    }

    private StackNode<E> head;

    private int size;//有效元素


    public MyStackByList() {

    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return null == head;
    }

    /**
     * 查看栈顶元素
     * @return
     */
    public synchronized E peek() {
        if (null == head){
            return null;
        }
        return head.val;
    }


    /**
     * 弹出栈顶元素
     * @return
     */
    public E pop() {
        if (null == head){
            return null;
        }
        E obj = peek();
        size--;
        head = head.next;
        return obj;
    }

    public E push(E item) {
        if (null == head){
            head = new StackNode<>();
            head.val = item;
        }else {
            StackNode<E> curr = new StackNode<>();
            curr.val = item;
            curr.next = head;
            head = curr;
        }
        size++;
        return item;
    }



    class StackNode<E> {
        private E val;
        private StackNode next;
    }



}
