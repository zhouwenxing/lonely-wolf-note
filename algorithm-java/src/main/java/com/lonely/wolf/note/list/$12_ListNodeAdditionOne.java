package com.lonely.wolf.note.list;

import java.util.Stack;

/**
 * 单链表加1
 * ⽤⼀个⾮空单链表来表示⼀个⾮负整数，然后将这个整数加⼀,这个整数的各个数位按照⾼位在链表头部、低位在链表尾部的顺序排列。
 * 你可以假设这个整数除了 0 本身，没有任何前导的 0。
 *
 * 示例:输⼊: [1,2,3] 输出: [1,2,4]
 *
 * 解题思路：
 * 因为加法需要从低位开始计算，而链表低位又在链表尾部，所以可以使用栈或者链表反转来实现
 * 1、通过栈实现
 * 2、通过链表反转实现
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/25
 * @since jdk1.8
 */
public class $12_ListNodeAdditionOne {
    public static void main(String[] args) {
//        int[] arr1 = {9,9,9};
//        ListNode listNode = ListNodeInit.initLinkedList(arr1);
//        ListNode resultNode = additionOneByStack(listNode);


        int[] arr2 = {1,2,9};
        ListNode listNode2 = ListNodeInit.initLinkedList(arr2);
        ListNode resultNode2 = additionOneByStack2(listNode2);
        System.out.println("链表加1后结果为：" + ListNodeInit.toString(resultNode2));
    }


    /**
     * 1、通过栈实现
     * @param head
     * @return
     */
    public static ListNode additionOneByStack(ListNode head){
        if (null == head){
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (null != curr){
            stack.push(curr);
            curr = curr.next;
        }

        int carry = 0;
        while (!stack.isEmpty()){
            ListNode node = stack.pop();
            int val = node.val;
            if (null == node.next){//尾部
                if (val == 9){
                    node.val = 0;
                    carry = 1;
                } else {
                    node.val = val + 1;
                }
            } else {
              if (carry != 1){
                  break;
              }
              if (val == 9){
                  node.val = 0;
              }else{
                  node.val = val + 1;
                  carry = 0;
              }
            }
        }

        if (carry == 1){//说明最高位仍然需要进位
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }


    /**
     * 1、通过栈实现---优化版本
     * @param head
     * @return
     */
    public static ListNode additionOneByStack2(ListNode head){
        if (null == head){
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (null != curr){
            stack.push(curr);
            curr = curr.next;
        }

        int carry = 0;
        int add = 1;
        while (!stack.isEmpty()){
            ListNode node = stack.pop();
            int val = node.val;
            int sum = val + add + carry;
            node.val = sum >= 10 ? 0 : sum;
            carry = sum >= 10 ? 1 : 0;
            add = 0;
            if (null != node && carry == 0){
                break;
            }
        }

        if (carry == 1){//说明最高位仍然需要进位
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }


    /**
     * 通过链表反转实现
     * @param head
     * @return
     */
    public static ListNode additionOneByReverseList(ListNode head){
        // TODO
        return head;

    }





}
