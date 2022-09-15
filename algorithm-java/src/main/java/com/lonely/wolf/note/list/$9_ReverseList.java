package com.lonely.wolf.note.list;

/**
 * 链表反转专题
 *
 * 示例
 * 输⼊：head = [1,2,3,4,5] 输出：[5,4,3,2,1]
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/24
 * @since jdk1.8
 */
public class $9_ReverseList {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode listNode = ListNodeInit.initLinkedList(arr);
        System.out.println("初始链表：" + ListNodeInit.toString(listNode));
        ListNode resultNode1 = reverseByDirect(listNode);
        System.out.println("第一次反转后链表：" + ListNodeInit.toString(resultNode1));
        ListNode resultNode2 = reverseBySentryNode(resultNode1);
        System.out.println("第二次反转后链表：" + ListNodeInit.toString(resultNode2));
    }


    /**
     * 反转一个链表
     *
     * 解题思路
     * 直接强转
     *
     * 示例
     * 输⼊：head = [1,2,3,4,5] 输出：[5,4,3,2,1]
     *
     * @param head
     * @return
     */
    public static ListNode reverseByDirect(ListNode head){
        if (null == head || null == head.next){//空或者只有一个节点无需反转
            return head;
        }

        ListNode pre = null;
        ListNode curr = head;
        while (null != curr){
            ListNode next = curr.next;//记录下一个节点
            curr.next = pre;//将当前节点 next 指向已经反转的节点
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 反转一个链表
     *
     * 解题思路
     * 建立一个哨兵 sentry 节点，然后从原 head 节点开始遍历，依次将链表节点接入 sentry 节点即可。
     *
     * @param head
     * @return
     */
    public static ListNode reverseBySentryNode(ListNode head){
        if (null == head || null == head.next){//空或者只有一个节点无需反转
            return head;
        }

        ListNode sentry = new ListNode(-1);
        ListNode curr = head;
        while (null != curr){
            ListNode next = curr.next;//记录下一个节点，防止失联
            curr.next = sentry.next;
            sentry.next = curr;//当前节点要接入哨兵之后
            curr = next;
        }
        return sentry.next;
    }


    /**
     * 反转一个链表
     *
     * 解题思路
     * 通过递归实现
     *
     * @param head
     * @return
     */
    public static ListNode reverseByRecursion(ListNode head){
        if (null == head || null == head.next){//空或者只有一个节点无需反转
            return head;
        }

        ListNode newHead = reverseByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
