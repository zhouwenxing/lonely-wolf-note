package com.lonely.wolf.note.design.pattern.iterator;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/2
 * @since jdk1.8
 */
public interface IBaggageCollection {
    void add(Baggage baggage);

    void remove(Baggage baggage);

    int size();

    IMyIterator<Baggage> iterator();
}
