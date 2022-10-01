package com.lonely.wolf.note.list;

/**
 * 给你⼀个链表，每 k 个节点⼀组进⾏翻转，请你返回翻转后的链表。k 是⼀个正整数，它的值⼩于或等于链表的⻓度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 * 你可以设计⼀个只使⽤常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，⽽是需要实际进⾏节点交换。
 *
 * 示例 输⼊：head = [1,2,3,4,5], k = 2  输出：[2,1,4,3,5]
 *
 * 解题思路
 * 1、穿针引线法
 * 2、头插法
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/25
 * @since jdk1.8
 */
public class $11_ReverseListExtra2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
//        ListNode head = ListNodeInit.initLinkedList(arr);
//        ListNode resultNode = reverse1(head,3);
//        System.out.println(ListNodeInit.toString(resultNode));
//
//        ListNode head2 = ListNodeInit.initLinkedList(arr);
//        ListNode resultNode2 = reverse1(head2,3);
//        System.out.println(ListNodeInit.toString(resultNode2));
//
//        ListNode head3 = ListNodeInit.initLinkedList(arr);
//        ListNode resultNode3 = reverse1_1(head3,6);
//        System.out.println(ListNodeInit.toString(resultNode3));

        ListNode head4 = ListNodeInit.initLinkedList(arr);
        ListNode resultNode4 = swapPairs(head4);
        System.out.println(ListNodeInit.toString(resultNode4));

    }




    /**
     * 穿针引线法
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverse1(ListNode head,int k){
        if (null == head || null == head.next || k <=1){
            return head;
        }

        int tlen = ListNodeInit.getListLength(head);
        int reverseNum = tlen / k;

        ListNode sentry = new ListNode(-1);
        sentry.next = head;

        ListNode pre = sentry;
        ListNode next = pre.next;
        ListNode curr;
        for (int n=1;n <= reverseNum;n++){
            int i=1;
            curr = next;
            ListNode start = curr;
            while (null != curr && i < k){
                curr = curr.next;
                i++;
            }
            if (null != curr){
                next = curr.next;//记录下一次开始反转的头节点
                curr.next = null;//断开
            }else{
                next = null;
            }
            pre.next = $9_ReverseList.reverseByDirect(start);//左边和反转后链表接上
            pre = start;//记录接上反转后链表的尾节点，下一次接入使用
        }
        pre.next = next;//接上最后一段
        return sentry.next;
    }


    /**
     * 穿针引线法
     *
     * 相比较 reverse1 做了优化
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverse1_1(ListNode head,int k){
        if (null == head || null == head.next || k <=1){
            return head;
        }

        int tlen = ListNodeInit.getListLength(head);
        int reverseNum = tlen / k;

        ListNode sentry = new ListNode(-1);
        sentry.next = head;


        ListNode pre = sentry;
        ListNode end = sentry;
        while (null != end){
            for (int i=1;i <= k && null != end;i++){
                end = end.next;
            }
            if (null == end){//说明最后一段已经小于 k，这个判断使得可以不去计算长度
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;

            pre.next = $9_ReverseList.reverseByDirect(start);//左边和反转后链表接上
            start.next = next;//进入下一个区间
            end = pre = start;//已反转链表的最后一个节点
        }
        return sentry.next;
    }


    /**
     * 头插法
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverse2(ListNode head,int k){
        if (null == head || null == head.next || k <=1){
            return head;
        }

        ListNode sentry = new ListNode(-1);
        sentry.next = head;



        return sentry.next;
    }




    /**
     * Leetcode 24 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 注意：你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 解题思路：这道题其实把上面 每 k 个节点⼀组进⾏翻转题目中k=2的场景。
     * 不过当确定 k 为 2时，可以有更简单的思路，那就是把后面两个节点都读出来，然后直接交换即可。
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head){
        if (null == head || null == head.next || null == head.next.next){
            return head;
        }

        ListNode sentry = new ListNode(-1);
        sentry.next = head;

        ListNode curr = sentry;
        while (null != curr.next && null != curr.next.next){
            ListNode next = curr.next;
            ListNode nextnext = curr.next.next;

            curr.next = nextnext;
            next.next = nextnext.next;
            nextnext.next = next;

            curr = next;//此时next已经被换到后面
        }
        return sentry.next;
    }

    /**----------------------------------------------以下为复盘练习使用方法-----------------------------------------*/

    public static ListNode testReverse1(ListNode head,int k){
        if (null == head || head.next == null || k <= 1){
            return head;
        }
        int len = ListNodeInit.getListLength(head);
        int rc = len / k;

        int i=1;
        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        ListNode pre = null;
        ListNode curr = head;
        while (i++ < rc){
            int j = 0;
            while (j<=k && null != curr){
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
        }
        return sentry.next;
    }

}
