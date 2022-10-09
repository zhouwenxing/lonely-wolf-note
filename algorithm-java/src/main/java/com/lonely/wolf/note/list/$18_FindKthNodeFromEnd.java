package com.lonely.wolf.note.list;

import java.util.Stack;

/**
 * 找到链表的倒数第 k 个节点，k从1开始计算
 *
 * 解题思路1：两次遍历法。第一次遍历获取到长度，第二次遍历到 length-k+1即为倒数第k个节点
 * 解题思路2：通过栈来处理。先全部入栈，然后出栈，第 k 个出栈的就是倒数第k个节点
 * 解题思路3：通过双指针处理。first先走k步，然后senond指针从头走，first继续走，当first走到最后，second指针位置就是倒数第k个节点
 */
public class $18_FindKthNodeFromEnd {

    public static void main(String[] args) {
        int[] arr = {1,2};
        int k = 1;
        ListNode head = ListNodeInit.initLinkedList(arr);
        System.out.println(getKthFromEndByTwoIteration(head,k).val);
        System.out.println(getKthFromEndByStack(head,k).val);
        System.out.println(getKthFromEndByDoublePoint(head,k).val);
    }


    /**
     * 两次迭代法
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEndByTwoIteration(ListNode head,int k){
        if (null == head || k < 1){
            return head;
        }
        int len = ListNodeInit.getListLength(head);

        int start = 1;
        int end = len - k + 1;

        ListNode curr = head;
        while (start < end && null != curr){
            curr = curr.next;
            start++;
        }
        return curr;
    }


    public static ListNode getKthFromEndByStack(ListNode head,int k){
        if (null == head || k < 1){
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (null != curr){
            stack.push(curr);
            curr = curr.next;
        }

        //出栈
        int i = 1;
        ListNode kNode = null;
        while (i <= k){
            kNode = stack.pop();
            i++;
        }
        return kNode;
    }


    public static ListNode getKthFromEndByDoublePoint(ListNode head,int k){
        if (null == head || k < 1){
            return head;
        }
        ListNode first = head;
        int count = 1;
        while (count <= k){
            first = first.next;
            count++;
        }

        ListNode second = head;
        while (null != first){
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
