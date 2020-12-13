package com.lonely.wolf.note.design.pattern.iterator;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/2
 * @since jdk1.8
 */
public interface IMyIterator<E> {

    E next();//遍历下一个元素

    boolean hasNext();//是否有下一个元素

}
