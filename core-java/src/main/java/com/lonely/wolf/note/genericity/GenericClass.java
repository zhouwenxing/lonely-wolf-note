package com.lonely.wolf.note.genericity;

import java.util.Map;

/**
 * 泛型类
 * @author zwx
 * @version 1.0
 * @date 2020/10/8
 * @since jdk1.8
 */
public class GenericClass<K,V,M> {
    private M name;
    private Map<K,V> map;


    public V test(M m){
        return null;
    }

}
