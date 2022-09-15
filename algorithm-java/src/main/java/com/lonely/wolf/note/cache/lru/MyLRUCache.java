package com.lonely.wolf.note.cache.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 运⽤你所掌握的数据结构，设计和实现⼀个LRU (最近最少使⽤) 缓存机制 。
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存。
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插⼊该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写⼊新数据之前删除最久未使⽤的数据值，从⽽为新的数据值留出空间。
 *
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/26
 * @since jdk1.8
 */
public class MyLRUCache {
    public static void main(String[] args) {
        MyLRUCache lRUCache = new MyLRUCache(2);
        lRUCache.put(1, 10); // 缓存是 {1=1}
        lRUCache.put(2, 20); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 30); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));;    // 返回 -1 (未找到)
        lRUCache.put(4, 40); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));;    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));;    // 返回 3
        System.out.println(lRUCache.get(4));;    // 返回 4
    }


    private Map<Integer,LinkedNode> cache = new HashMap<>();

    private LinkedNode head,tail;

    private int capacity;//当前队列容量

    private int size;//当前队列的有效元素数量


    public MyLRUCache() {
    }

    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;

        //构建2个虚拟节点
        head = new LinkedNode();//虚拟头节点
        tail = new LinkedNode();//虚拟尾节点
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 1、如果 key 不存在，则返回 -1
     * 2、如果 key 存在，则 key 对应的节点是最近被使⽤的节点，需要将其移到头部
     *
     * @param key
     * @return
     */
    public int get(int key){
        LinkedNode node = cache.get(key);
        if (null == node){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }


    /**
     * 1、如果 key 存在，则将其移到头部
     *
     *
     *
     * @param key
     * @param value
     */
    public void put(int key,int value) {
        LinkedNode node = cache.get(key);
        //已经在缓存
        if (null != node){
            node.value = value;
            moveToHead(node);
            return;
        }
        //不在缓存
        node = new LinkedNode(key,value);
        cache.put(key,node);//新节点加入哈希表
        if (size == capacity){//容量已满
            removeNodeFromTail();//将尾部节点移除
            addToHead(node);//新节点加入头部
        }else{//缓存队列容量够的话直接存入即可
            addToHead(node);
            size++;
        }
    }

    /**
     * 注意尾部是虚拟节点
     */
    private void removeNodeFromTail() {
        removeNode(tail.pre);
    }


    private void moveToHead(LinkedNode node) {
        if (head.next.key == node.key && head.next.value == node.value){//已经在头部，无需处理
            return;
        }
        //删除原节点
        removeNode(node);

        //加入头部
        addToHead(node);
    }

    /**
     * 注意头部是虚拟节点，加入头部实际上是假如第二个位置
     * @param node
     */
    private void addToHead(LinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(LinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


    class LinkedNode {
        private int key;
        private int value;

        private LinkedNode pre;
        private LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
