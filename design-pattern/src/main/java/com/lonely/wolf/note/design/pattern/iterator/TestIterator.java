package com.lonely.wolf.note.design.pattern.iterator;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/2
 * @since jdk1.8
 */
public class TestIterator {

    public static void main(String[] args) {
        IBaggageCollection iBaggageCollection = initBaggage();
        System.out.println("当前对象元素个数为：" + iBaggageCollection.size() + "个");
        IMyIterator<Baggage> it = iBaggageCollection.iterator();
        while (it.hasNext()){
            Baggage baggage = it.next();
            System.out.println(baggage.getName());
        }
    }

    private static IBaggageCollection initBaggage() {
        IBaggageCollection iBaggageCollection = new BaggageCollectionImpl();
        for (int i=0;i<10;i++){
            Baggage box = new Baggage("箱子" + (i+1));
            iBaggageCollection.add(box);
        }

        return iBaggageCollection;
    }
}
