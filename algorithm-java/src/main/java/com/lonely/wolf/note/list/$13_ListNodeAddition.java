package com.lonely.wolf.note.list;

import java.util.Stack;

/**
 * 链表加法：
 * 假设链表中每⼀个节点的值都在 0 - 9 之间，那么链表整体就可以代表⼀个整数。给定两个这种链表，请⽣成代表两个整数相加值的结果链表。
 *
 * 解题思路
 * 和 $12_ListNodeAdditionOne- 单链表加1思路一致，通过栈或者反转列表来实现
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/25
 * @since jdk1.8
 */
public class $13_ListNodeAddition {

    public static void main(String[] args) {
        int[] arr1 = {4,8,9,1,2};
        int[] arr2 = {7,3,1,9,9};
        ListNode listNode1 = ListNodeInit.initLinkedList(arr1);
        ListNode listNode2 = ListNodeInit.initLinkedList(arr2);
//        ListNode resultNode = additionByStack(listNode1,listNode2);
//        ListNode resultNode = additionByStack2(listNode1,listNode2);
//        ListNode resultNode = additionByReverseList(listNode1,listNode2);
//        System.out.println("相加后链表为：" + ListNodeInit.toString(resultNode));

        ListNode resultNode2 = testAdditionByStack(listNode1,listNode2);
        System.out.println("相加后链表为：" + ListNodeInit.toString(resultNode2));

    }


    /**
     * 通过栈实现
     *
     * 解题思路：首先将链表中的元素存到两个栈里面，然后出栈相加（要注意进位），将结果组成一个新的链表，最后将链表反转
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode additionByStack(ListNode head1,ListNode head2){
        if (null == head1 || null == head2){
            return null == head1 ? head2 : head1;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        ListNode curr1 = head1;
        ListNode curr2 = head2;

        while (null != curr1 && null != curr2){
            stack1.push(curr1);
            stack2.push(curr2);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while (null != curr1){
            stack1.push(curr1);
            curr1 = curr1.next;
        }
        while (null != curr2){
            stack2.push(curr2);
            curr2 = curr2.next;
        }

        ListNode sentry = new ListNode(-1);

        ListNode curr = sentry;
        ListNode next;
        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            int val1 = stack1.pop().val;
            int val2 = stack2.pop().val;
            int sum = val1 + val2 + carry;

            int newVal = sum >= 10 ? sum % 10 : sum;
            carry = sum >=10 ? 1: 0;

            ListNode node = new ListNode(newVal);
            next = curr.next;
            curr.next = node;
            node.next = next;
        }

        while (!stack1.isEmpty() || !stack2.isEmpty()){
            int val = stack1.isEmpty() ? stack2.pop().val : stack1.pop().val;
            int sum = val + carry;
            carry = sum >=10 ? 1: 0;

            ListNode node = new ListNode(sum >= 10 ? sum % 10 : sum);
            next = curr.next;
            curr.next = node;
            node.next = next;
        }
        if (carry == 1){
            ListNode node = new ListNode(1);
            next = curr.next;
            node.next = next;
            curr.next = node;
        }
        return sentry.next;
    }


    /**
     * 通过栈实现 - 优化版本
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode additionByStack2(ListNode head1,ListNode head2){
        if (null == head1 || null == head2){
            return null == head1 ? head2 : head1;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        ListNode curr1 = head1;
        ListNode curr2 = head2;

        while (null != curr1 && null != curr2){
            stack1.push(curr1);
            stack2.push(curr2);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while (null != curr1){
            stack1.push(curr1);
            curr1 = curr1.next;
        }
        while (null != curr2){
            stack2.push(curr2);
            curr2 = curr2.next;
        }

        ListNode sentry = new ListNode(-1);

        ListNode curr = sentry;
        ListNode next;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int val1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int val2 = stack2.isEmpty() ? 0 : stack2.pop().val;

            int sum = val1 + val2 + carry;
            int newVal = sum >= 10 ? sum % 10 : sum;
            carry = sum >=10 ? 1: 0;

            ListNode node = new ListNode(newVal);
            next = curr.next;
            curr.next = node;
            node.next = next;
        }
        return sentry.next;
    }


    /**
     * 通过链表反转实现
     *
     * 解题思路
     * 首先将两个链表分表反转，然后遍历相加，最后将结果再做一次反转
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode additionByReverseList(ListNode head1,ListNode head2){
        if (null == head1 || null == head2){
            return null == head1 ? head2 : head1;
        }

        head1 = $9_ReverseList.reverseByDirect(head1);
        head2 = $9_ReverseList.reverseByDirect(head2);

        ListNode sentry = new ListNode(-1);

        ListNode curr = sentry;
        ListNode next;
        int carry = 0;
        while (null != head1 || null != head2 || carry != 0){
            int sum = carry;
            if (null != head1){
                sum+= head1.val;
                head1 = head1.next;
            }
            if (null != head2){
                sum+= head2.val;
                head2 = head2.next;
            }

            int newVal = sum >= 10 ? sum % 10 : sum;
            carry = sum >=10 ? 1: 0;

            ListNode node = new ListNode(newVal);
            next = curr.next;
            curr.next = node;
            node.next = next;
        }
        return sentry.next;
    }

    /**----------------------------------------------以下为复盘练习使用方法-----------------------------------------*/

    public static ListNode testAdditionByStack(ListNode head1,ListNode head2){
        if (null == head1){
            return head2;
        }
        if (null == head2){
            return head1;
        }

        //将链表存入栈内
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        while (null != curr1 && null != curr2){
            stack1.push(curr1);
            stack2.push(curr2);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while (null != curr1){
            stack1.push(curr1);
            curr1 = curr1.next;
        }
        while (null != curr2){
            stack2.push(curr2);
            curr2 = curr2.next;
        }

        //出栈相加
        int carry = 0;//进位
        ListNode sentry = new ListNode(-1);
        ListNode curr = sentry;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            int num1 = stack1.pop().val;
            int num2 = stack2.pop().val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        while (!stack1.isEmpty()){
            int num = stack1.pop().val;
            int sum = num + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        while (!stack2.isEmpty()){
            int num = stack2.pop().val;
            int sum = num + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        if (carry == 1){
            curr.next = new ListNode(1);
        }

        ListNode newHead = sentry.next;
        sentry.next = null;
        return $9_ReverseList.reverseByDirect(newHead);
    }

}
