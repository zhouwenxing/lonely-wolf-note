package com.lonely.wolf.note.list;

/**
 * 旋转列表
 * 给你⼀个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 * 示例
 * 输⼊：head = [1,2,3,4,5], k = 2  输出：[4,5,1,2,3]
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/25
 * @since jdk1.8
 */
public class $15_RotateList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode listNode = ListNodeInit.initLinkedList(arr);
//        ListNode resultNode = rotateListByReverse(listNode,4);
        ListNode resultNode = rotateListByDoublePoint(listNode,3);
        System.out.println("旋转后链表为：" + ListNodeInit.toString(resultNode));
    }


    /**
     * 通过反转链表实现
     *
     * 解题思路
     * 1、首先将整个链表反转，然后将前 k 和 剩余的 n-k 个元素分别反转，接连上即可
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateListByReverse(ListNode head,int k){
        if (null == head || null == head.next || k <= 0){
            return head;
        }

        ListNode temp = head;
        int len = ListNodeInit.getListLength(temp);
        k = k % len;
        if (k == 0){//0 则表示不反转
            return head;
        }

        //将链表转不反转
        ListNode newHead = $9_ReverseList.reverseByDirect(head);

        ListNode sentry = new ListNode(-1);
        sentry.next = newHead;

        ListNode pre = sentry;
        ListNode end = sentry;
        for (int i=0;i < k;i++){
            end = end.next;
        }
        ListNode start = pre.next;
        ListNode next = end.next;//下一段反转的头节点
        end.next = null;//断开
        pre.next = $9_ReverseList.reverseByDirect(start);
        start.next = $9_ReverseList.reverseByDirect(next);

        return sentry.next;
    }



    /**
     * 通过快慢双指针实现
     *
     * 解题思路：联想寻找倒数第 k 个元素的思想
     *
     * 1、快指针先⾛ k 步
     * 2、慢指针和快指针⼀起⾛
     * 3、快指针⾛到链表尾部时，慢指针刚好⾛到倒数第 k 个位置
     * 4、将快指针指向原链表头部，慢指针指向的节点断开和下个节点的联系
     * 5、返回慢指针指向的位置
     * 6、此时慢指针的下一个节点指向的位置即为旋转后链表的头部
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateListByDoublePoint(ListNode head,int k){
        if (null == head || null == head.next || k <= 0){
            return head;
        }

        ListNode temp = head;
        int len = ListNodeInit.getListLength(temp);
        k = k % len;
        if (k == 0){//0 则表示不反转
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        int i = 1;
        while (i <= k){
            fast = fast.next;
            i++;
        }

        while (null != fast.next){
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        ListNode newHead = slow.next;
        slow.next = null;

        return newHead;
    }
}
