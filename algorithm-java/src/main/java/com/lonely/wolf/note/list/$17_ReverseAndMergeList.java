package com.lonely.wolf.note.list;

/**
 * 重排链表
 *
 * 给定一个链表：L1->L2->...->Ln-1->Ln
 * 将其重排列后变为：L1->Ln->L2->Ln-1...
 *
 * 示例
 * 给定链表：1->2->3->4，输出：1->4->2->3
 * 给定链表：1->2->3->4->5，输出：1->5->2->4->3
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/9/28
 * @since jdk1.8
 */
public class $17_ReverseAndMergeList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode listNode = ListNodeInit.initLinkedList(arr);
        System.out.println("初始链表：" + ListNodeInit.toString(listNode));
        ListNode resultNode1 = reverseAndMergeList(listNode);
        System.out.println("重排后链表：" + ListNodeInit.toString(resultNode1));
    }


    /**
     * 解题思路：
     * 这道题其实基本思路是要找到中点，找到之后将其断开，并反转右半部分链表，然后将两段链表进行合并
     *
     * 寻找中点可利用快慢双指针法：
     * 1.如果链表为奇数，那么当快指针走到最后，慢指针恰好在中间，此时中间节点是多出来的，可不参与反转
     * 2.如果链表为偶数，当快指针走到倒数第二个节点时，慢指针恰好走到左边部分的最后一个节点
     * 综合两种情况，当快指针，且快指针下一个位置(fast.next.next)，不为空时，从慢指针的下一个节点开始断开即可
     *
     * @param head
     * @return
     */
    public static ListNode reverseAndMergeList(ListNode head){
        if (null == head || null == head.next || null == head.next.next){
            return head;
        }
        //寻找中点
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && null != fast.next && null != fast.next.next){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;//右半部分链表的头结点
        slow.next = null;//断开左右两部分链表
        ListNode rightHeadNew = $9_ReverseList.reverseByDirect(right);//将右边链表反转

        ListNode newHead = head;
        ListNode curr = head;

        ListNode leftNext = head.next;
        ListNode rightNext = rightHeadNew;
        int count = 0;
        while (null != rightNext){
            if (count % 2 == 1){//奇数，接左边
                curr.next = leftNext;
                leftNext = leftNext.next;
            }else {//偶数，接右边
                curr.next = rightNext;
                rightNext = rightNext.next;
            }
            curr = curr.next;
            count++;
        }
        curr.next = leftNext;
        return newHead;
    }

}
