package com.lonely.wolf.note.list;

/**
 * 合并两个有序链表
 *
 * 如果合并k个可以先合两个，然后用合并后的链表依次和其他链表合并
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/23
 * @since jdk1.8
 */
public class $5_MergeTwoList {
    public static void main(String[] args) {
        int[] arr1 = {1,7,10};
        int[] arr2 = {2,6,9};
        ListNode listNode1 = ListNodeInit.initLinkedList(arr1);
        ListNode listNode2 = ListNodeInit.initLinkedList(arr2);

        ListNode newList = mergeTwoList(listNode1,listNode2);
        System.out.println("普通合并法：" + ListNodeInit.getListLength(newList));

        ListNode listNode3 = ListNodeInit.initLinkedList(arr1);
        ListNode listNode4 = ListNodeInit.initLinkedList(arr2);
        ListNode newList2 = mergeTwoListByRecursion(listNode3,listNode4);
        System.out.println("递归合并法：" + ListNodeInit.getListLength(newList2));

    }



    public static ListNode mergeTwoList(ListNode head1,ListNode head2){
        ListNode sentryNode = new ListNode(-1);//哨兵节点
        ListNode curr = sentryNode;
        while (null != head1 && null != head2){
            if (head1.val < head2.val){
                curr.next = head1;
                head1 = head1.next;
            }else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        //到这里最多有一个链表剩余节点，也可能都结束了,链表的好处就是不需要继续循环，直接接上剩余链表就行
        curr.next = null == head1 ? head2 : head1;//如果两个都为空，那么接任意一个都没关系，都是Null
        return sentryNode.next;
    }


    /**
     *  递归合并两个链表
     *
     *  每次递归寻找最小节点
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeTwoListByRecursion(ListNode head1,ListNode head2){
        if (null == head1){
            return head2;
        }
        if (null == head2){
            return head1;
        }

        if (head1.val < head2.val){
            head1.next = mergeTwoListByRecursion(head1.next,head2);
            return head1;
        } else {
            head2.next = mergeTwoListByRecursion(head1,head2.next);
            return head2;
        }
    }

    /**----------------------------------------------------以下为复盘练习使用方法---------------------------------------------*/

    public static ListNode testMergeTwoListByRecursion(ListNode head1,ListNode head2){
        if (null == head1){
            return head2;
        }
        if (null == head2){
            return head1;
        }
        int val1 = head1.val;
        int val2 = head2.val;
        ListNode newHead;
        if (val1 < val2){
            head1.next = testMergeTwoListByRecursion(head1.next,head2);
            return head1;
        }else{
            head2.next = testMergeTwoListByRecursion(head1,head2.next);
            return head2;
        }
    }
}
