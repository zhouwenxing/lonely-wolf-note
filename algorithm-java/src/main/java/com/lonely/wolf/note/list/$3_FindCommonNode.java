package com.lonely.wolf.note.list;

import java.util.*;

/**
 * 找出两个链表的第⼀个公共节点
 *
 * 题目：两个链表的头结点都是已知的，相交之后成为⼀个单链表，但是相交的位置未知，并且相交之前的结点数也是未知
 * 的，请设计算法找到两个链表的合并点。
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/21
 * @since jdk1.8
 */
public class $3_FindCommonNode {
    public static void main(String[] args) {
        //初始化链表
        int[] arr1 = {0,1,2,3};
        int[] arr2 = {6,7};
        ListNode list1 = ListNodeInit.initLinkedList(arr1);
        ListNode list2 = ListNodeInit.initLinkedList(arr2);

        //构建两个公共节点
        ListNode commonNode1 = new ListNode(4);
        ListNode commonNode2 = new ListNode(5);
        commonNode1.next = commonNode2;

        //插入公共节点
        ListNodeInit.insertNode(list1,commonNode1,5);
        ListNodeInit.insertNode(list2,commonNode1,3);

        ListNode listNode1 = findByHash(list1,list2);
        System.out.println("哈希寻找第一个公共节点：" + (null == listNode1 ? null : listNode1.getVal()));

        ListNode listNode2 = findByStack(list1,list2);
        System.out.println("stack寻找第一个公共节点：" + (null == listNode2 ? null : listNode2.getVal()));

        ListNode listNode3 = findByMergeList(list1,list2);
        System.out.println("merge list寻找第一个公共节点：" + (null == listNode3 ? null : listNode3.getVal()));

        ListNode listNode4 = findByMergeSubTwoPoint(list1,list2);
        System.out.println("sub point寻找第一个公共节点：" + (null == listNode4 ? null : listNode4.getVal()));

    }


    /**
     * 可以存入map或者set集合，利用哈希匹配
     * 空间复杂度O(n)
     * @param head1 - 链表1头节点
     * @param head2 - 链表2头节点
     * @return
     */
    public static ListNode findByHash(ListNode head1,ListNode head2){
        Set<ListNode> set = new HashSet<>();
        ListNode _head1 = head1;
        ListNode _head2 = head2;

        while (null != _head1){//将链表1节点存入set集合
            set.add(_head1);
            _head1 = _head1.next;
        }

        while (null != _head2){//遍历链表2，寻找相同节点
            if (set.contains(_head2)){
                return _head2;
            }
            _head2 = _head2.next;
        }
        return null;
    }


    /**
     * 存入两个栈，分别将两个链表的结点⼊两个栈，然后分别出栈，如果相等就继续出栈，不相等则前一个出栈节点就是公共节点
     * 空间复杂度O(m+n)，即两个栈空间大小
     * @param head1 - 链表1头节点
     * @param head2 - 链表2头节点
     * @return
     */
    public static ListNode findByStack(ListNode head1,ListNode head2){
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        ListNode _head1 = head1;
        ListNode _head2 = head2;

        while (null != _head1){//遍历链表1
            stack1.push(_head1);
            _head1 = _head1.next;
        }

        while (null != _head2){//遍历链表2
            stack2.push(_head2);
            _head2 = _head2.next;
        }

        ListNode commonNode = null;
        while (stack1.size() > 0 && stack2.size() > 0){
            if (stack1.peek() == stack2.peek()){
                commonNode = stack1.pop();//stack1弹出
                stack2.pop();//stack2弹出
            }else {
                break;//不相等则退出循环
            }
        }
        return commonNode;
    }


    /**
     * 列表合并法，比如两个链表A和B   A: 0-1-2-3-4-5 B: a-b-4-5
     *
     * AB：0-1-2-3-4-5-a-b-4-5
     * BA：a-b-4-5-0-1-2-3-4-5
     *
     * 相当于构建两个等长链表，然后同时开始遍历，找到相等节点则为第一个共同节点。
     * 如果新建⽴两个链表太浪费空间了，所以采用取巧方式，当某一个链表循环完成之后，指针指向另一个链表的头节点，继续遍历
     * @param head1 - 链表1头节点
     * @param head2 - 链表2头节点
     * @return
     */
    public static ListNode findByMergeList(ListNode head1,ListNode head2){
        ListNode _head1 = head1;
        ListNode _head2 = head2;

        while(_head1 != _head2){
            _head1 = _head1.next;
            _head2 = _head2.next;
            if (_head1 != _head2){
                if (null == _head1){
                    _head1 = head2;
                }
                if (null == _head2){
                    _head2 = head1;
                }
            }
        }
        return _head1;
    }



    /**
     * 差和双指针
     *
     * 假如公共⼦节点⼀定存在第⼀轮遍历，假设La⻓度为L1，Lb⻓度为L2.则｜L2-L1｜就是两个的差值。第⼆轮遍历，
     * ⻓的先⾛｜L2-L1｜,然后两个链表同时向前⾛，结点⼀样的时候就是公共结点了
     *
     * 这道题的思路还是为了构建相同的链表去遍历，因为多出来的节点肯定不可能是相同节点，所以可以先遍历掉
     *
     * @param head1 - 链表1头节点
     * @param head2 - 链表2头节点
     * @return
     */
    public static ListNode findByMergeSubTwoPoint(ListNode head1,ListNode head2){
        ListNode _curr1 = head1;
        ListNode _curr2 = head2;

        int len1 = 0;
        int len2 = 0;

        while (null != _curr1) {//获取链表1长度
            len1++;
            _curr1 = _curr1.next;
        }

        while (null !=_curr2) {//获取链表2长度
            len2++;
            _curr2 = _curr2.next;
        }

        //重置当前节点
        _curr1 = head1;
        _curr2 = head2;

        //将差值先遍历
        int count = 0;
        if (len1 > len2){
            int subLength = len1 - len2;
            while (count++ < subLength){
                _curr1 = _curr1.next;
            }
        }else if (len1 < len2){
            int subLength = len2 - len1;
            while (count++ < subLength){
                _curr2 = _curr2.next;
            }
        }

        //此时两个链表剩余长度一致，可以同步遍历，直到找到相同节点
        while (_curr1 != _curr2){
            _curr1 = _curr1.next;
            _curr2 = _curr2.next;
        }
        return _curr1;
    }
}
