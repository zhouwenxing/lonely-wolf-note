package com.lonely.wolf.note.list;

/**
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/23
 * @since jdk1.8
 */
public class ListNodeInit {

    public static ListNode initLinkedList(int[] array) {
        ListNode head = null, cur = null;
        for (int i = 0; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
        }
        return head;
    }


    public static void insertNode(ListNode head, ListNode insertNode, int position) {
        if (null == head){//当前没有链表
            return;
        }
        int size = getListLength(head);
        if (position < 0 || position > size + 1){//越界
            return;
        }
        //插入头部
        if (position == 1){
            insertNode.next = head;
            head = insertNode;
            return;
        }

        ListNode prevNode = head;
        int i = 1;
        while (i < position-1) {//遍历到position的前一个节点
            prevNode = prevNode.next;
            i++;
        }
        if (null == prevNode){
            return;
        }

        insertNode.next = prevNode.next;
        prevNode.next = insertNode;
    }


    public static int getListLength(ListNode head){
        int length = 0;
        while (null != head){
            length++;
            head = head.next;
        }
        return length;
    }

    /**
     * 输出链表
     *
     * @param head 头节点
     */
    public static String toString(ListNode head) {
        ListNode current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.val).append("\t");
            current = current.next;
        }
        return "".equals(sb.toString()) ? "无元素" : sb.toString();
    }
}
