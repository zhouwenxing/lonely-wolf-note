package com.lonely.wolf.note.design.pattern.iterator;

import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/2
 * @since jdk1.8
 */
public class MyIteratorImpl<E> implements IMyIterator<E> {
    private List<E> list;
    private int cursor;
    private E element;
    private int size;

    public MyIteratorImpl(List<E> list) {
        this.list = list;
        this.size = list.size();
    }

    @Override
    public E next() {
        E element = list.get(cursor);
        cursor++;
        return element;
    }

    @Override
    public boolean hasNext() {
        return cursor != size;
    }
}
