package com.lonely.wolf.note.list;

/**
 * 指定区间反转链表
 *
 * LeetCode92 ：给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回反转后的链表。
 *
 * 验证
 * 输⼊：head = [1,2,3,4,5], left = 2, right = 4  输出：[1,4,3,2,5]
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/25
 * @since jdk1.8
 */
public class $10_ReverseListExtra1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode listNode = ListNodeInit.initLinkedList(arr);
        System.out.println("初始链表：" + ListNodeInit.toString(listNode));
        ListNode resultNode = reverseBetweenZone(listNode,2,5);
        System.out.println("反转链表：" + ListNodeInit.toString(resultNode));
        ListNode listNode2 = ListNodeInit.initLinkedList(arr);
        ListNode resultNode2 = testReverseBetweenZone(listNode2,2,5);
        System.out.println("反转链表2：" + ListNodeInit.toString(resultNode2));

        ListNode listNode3 = ListNodeInit.initLinkedList(arr);
        ListNode resultNode3 = reverseBetweenZone2(listNode3,2,5);
        System.out.println("反转链表3：" + ListNodeInit.toString(resultNode3));
    }


    /**
     * 解题思路
     * 自己第一时间想到的办法
     * 借助哨兵，定义一个变量，当变量到 left 开始反转，当变量到 right+1，停止反转
     *
     * 这是头插法
     *
     * 另外还有一种穿针引线法，需要遍历两次，第一次遍历找到 left，然后继续遍历找到 right，并切断 right 之后的链表，然后单独逆转 left 为头节点的链表，逆转后再将三段链表重新接起来
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetweenZone(ListNode head,int left,int right){
        if (null == head || null == head.next || left > right){
            return head;
        }

        ListNode sentry = new ListNode(-1);
        sentry.next = head;

        int i = 1;
        ListNode curr = head;
        ListNode start = sentry;//记录开始反转链表的前一个节点
        while (null != curr && i < left){
            start = curr;
            curr = curr.next;
            i++;
        }

        ListNode pre = null;//链表反转前的最后一个节点，反转后就成为了第一个节点，start 接上 pre 即可
        ListNode next = curr.next;//反转之后，next 为 null 或者反转区间 right 外的第一个节点
        ListNode end = curr;//记录第一个反转节点，即反转后的最后一个节点
        while (i >= left && i<= right && null != curr){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            i++;
        }
        start.next = pre;
        end.next = next;
        return sentry.next;
    }


    /**
     * 穿针引线法
     * 本质上和头插法区别不大，无非是穿针引线法需要先切断反转区间的链表之后再进行反转，然后拼接三段链表
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetweenZone2(ListNode head,int left,int right){
        if (null == head || null == head.next || left > right || left <=0){
            return head;
        }

        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        ListNode leftNode = head;
        ListNode curr = head;
        ListNode start = head;
        int i=1;
        while (null != curr && i<left){
            leftNode = curr;
            start = curr = curr.next;
            i++;
        }
        ListNode end = curr;
        ListNode rightNode = curr;
        while (null !=curr && i<=right){
            end = curr;
            rightNode = curr = curr.next;
            i++;
        }

        leftNode.next = null;
        end.next = null;//切断需要反转的链表
        $9_ReverseList.reverseByDirect(start);//反转链表

        //拼接三段链表
        leftNode.next = end;
        start.next = rightNode;

        return sentry.next;

    }

    /**----------------------------------------------以下为复盘练习使用方法-----------------------------------------*/

    public static ListNode testReverseBetweenZone(ListNode head,int left,int right){
        if (null == head || null == head.next || left > right){
            return head;
        }
        int i = 1;
        ListNode sentryNode = new ListNode(-1);
        sentryNode.next = head;
        ListNode curr = head;
        ListNode start = sentryNode;
        while (i < left && null != curr){
            start = curr;
            curr = curr.next;
            i++;
        }

        ListNode pre = null;
        ListNode next = null;
        ListNode end = curr;
        while (null != curr && (i++) <= right){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        start.next = pre;
        end.next = next;
        return sentryNode.next;
    }
}
