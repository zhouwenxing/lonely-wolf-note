package com.lonely.wolf.note.design.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/2
 * @since jdk1.8
 */
public class BaggageCollectionImpl implements IBaggageCollection {
    private List list;

    public BaggageCollectionImpl() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(Baggage baggage) {
        list.add(baggage);
    }

    @Override
    public void remove(Baggage baggage) {
        list.remove(baggage);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public IMyIterator<Baggage> iterator() {
        return new MyIteratorImpl<Baggage>(list);
    }
}
