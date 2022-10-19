package com.lonely.wolf.note.recursion;


import com.alibaba.fastjson.JSONObject;
import com.lonely.wolf.note.list.ListNode;
import com.lonely.wolf.note.list.ListNodeInit;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归处理链表相关问题，如倒序打印链表，链表反转，链表合并等
 */
public class $1_RecursionForList {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode head = ListNodeInit.initLinkedList(arr);
//        printListFromEnd(head);//逆序打印
        System.out.println(ListNodeInit.toString(reverseListByRecurison(head)));//反转链表
    }


    /**
     * 通过递归倒序打印链表
     * @param head
     */
    public static void printListFromEnd(ListNode head){
        List<Integer> result = new ArrayList<>();
        recursion(head,result);
        System.out.println(JSONObject.toJSONString(result));
    }

    private static void recursion(ListNode head,List<Integer> result){
        if (null == head){
            return;
        }
        recursion(head.next,result);
        result.add(head.val);
    }


    /**
     * 通过递归处理链表反转问题
     * @param head
     * @return
     */
    public static ListNode reverseListByRecurison(ListNode head){
        if (null == head || null == head.next){
            return head;
        }
        ListNode node = reverseListByRecurison(head.next);
        ListNode node1 = head.next;
        node1.next = head;
        head.next = null;
        return node;
    }
}
