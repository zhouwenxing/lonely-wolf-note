package com.lonely.wolf.note.stack;

import java.util.Arrays;

/**
 * 基于数组来实现自定义栈
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/24
 * @since jdk1.8
 */
public class MyStackByArray<E> {
    public static void main(String[] args) {
        MyStackByArray stack = new MyStackByArray();
        stack.push(1);
        System.out.println("stack有效元素个数：" + stack.size);//输出 1
        System.out.println("查看栈顶元素：" + stack.peek());//输出 1
        System.out.println("栈是否为空：" + stack.isEmpty());//输出 false
        System.out.println("弹出栈顶元素：" + stack.pop());// 输出 1
        System.out.println("栈是否为空：" + stack.isEmpty());//输出 true
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("stack有效元素个数：" + stack.size);//输出 3
        System.out.println("弹出栈顶元素：" + stack.pop()); //输出 4
    }

    private Object[] element;

    private int size;//有效元素

    private int DEFAULT_SIZE = 2;//默认大小

    public MyStackByArray() {
        element = new Object[DEFAULT_SIZE];
    }

    /**
     * 判断是否为空，注意不能直接用数组的长度
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 查看栈顶元素
     * @return
     */
    public synchronized E peek() {
        if (size == 0){
            return null;
        }
        return (E)element[size-1];
    }


    /**
     * 弹出栈顶元素
     * @return
     */
    public E pop() {
        if (size == 0){
            return null;
        }
        E obj = peek();
        size--;//利用 size 省略元素的移除
        return obj;
    }

    /**
     * 压栈
     * @param item
     * @return
     */
    public E push(E item) {
        ensureCapacityAndGrow();
        element[size++] = item;
        return item;
    }

    /**
     * 扩容
     */
    private void ensureCapacityAndGrow() {
        int len = element.length;
        if (size + 1 > len){//扩容
            element = Arrays.copyOf(element,len * 2);
        }
    }
}
