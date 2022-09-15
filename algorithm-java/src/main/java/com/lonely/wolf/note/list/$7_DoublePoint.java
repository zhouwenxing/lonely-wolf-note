package com.lonely.wolf.note.list;

/**
 * 双指针相关练习
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/23
 * @since jdk1.8
 */
public class $7_DoublePoint {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode listNode = ListNodeInit.initLinkedList(arr);
        System.out.println(findMiddleNode(listNode).val);

        int[] arr2 = {1,2,3,4,5,6};
        ListNode listNode2 = ListNodeInit.initLinkedList(arr2);
        System.out.println(findKElementFromEnd(listNode2,10).val);

    }


    /**
     * 寻找中间节点
     *
     * 给定⼀个头结点为 head 的⾮空单链表，返回链表的中间结点。如果有两个中间结点，则返回第⼆个中间结点。
     * @param listNode
     * @return
     */
    public static ListNode findMiddleNode(ListNode listNode){
        if (null == listNode){
            return null;
        }

//        int length = ListNodeInit.getListLength(listNode);
//        if (length <= 2){
//            return null;
//        }

        ListNode slow = listNode;
        ListNode fast = listNode;
        while (null != fast && null != fast.next){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * 寻找倒数第K个元素(剑指 offer：22)
     *
     * 输⼊⼀个链表，输出该链表中倒数第k个节点。为了符合⼤多数⼈的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     *
     * 例如：给定⼀个链表: 1->2->3->4->5, 和 k = 2. 返回链表 4->5
     *
     * 解题思路：
     * 将第⼀个指针fast 指向链表的第 k+1 个节点，第⼆个指针 slow 指向链表的第⼀个节点，此时指针fast与slow ⼆者之间刚好间隔 k 个节点。
     * 此时两个指针同步向后⾛，当第⼀个指针fast ⾛到链表的尾部空节点时，则此时 slow 指针刚好指向链表的倒数第k个节点
     *
     * 注意：链表的长度可能小于 k
     * @param listNode
     * @param k
     * @return
     */
    public static ListNode findKElementFromEnd(ListNode listNode,int k){
        if (k <= 0){
            return null;
        }
        ListNode fast = listNode;
        ListNode slow = listNode;

        //fast指向k+1位置
//        int count=1;
//        while (count < k+1){//这种写法如果链表长度小于k会有问题
//            fast = fast.next;
//            count++;
//        }
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }

        while (null != fast){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


    /**
     * 旋转链表
     * 给你⼀个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     *
     * 例如：输⼊：head = [1,2,3,4,5], k = 2 输出：[4,5,1,2,3]
     *
     * 解题思路：⾸先将整个链表反转，然后再将前K个和N-K个分别反转，
     *
     * @param listNode
     * @param k
     * @return
     */
    public static ListNode rotateList1(ListNode listNode,int k){
        //TODO
        return null;
    }


    /**
     * 旋转链表
     * 给你⼀个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     *
     * 例如：输⼊：head = [1,2,3,4,5], k = 2 输出：[4,5,1,2,3]
     *
     * 解题思路：⾸先将整个链表反转，然后再将前K个和N-K个分别反转，
     *
     * @param listNode
     * @param k
     * @return
     */
    public static ListNode rotateList2(ListNode listNode,int k){
        return null;
    }
}
