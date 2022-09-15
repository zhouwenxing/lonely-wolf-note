package com.lonely.wolf.note.list;

/**
 * 单向链表的插入和删除操作
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/15
 * @since jdk1.8
 */
public class $1_InsertDeleteSinglyList {

    public static void main(String[] args) {
        // 头部添加节点1
        $1_InsertDeleteSinglyList.Node head = new Node(1);
        System.out.println(head);

        System.out.println("链表长度为：" + getListLength(head));
        //尾部添加节点2
        Node node = new Node(2);
        head = insertNode(head, node, 2);
        System.out.println(head);
        System.out.println("链表长度为：" + getListLength(head));

        //中部添加节点3
        Node node2 = new Node(3);
        head = insertNode(head, node2, 2);
        System.out.println(head);
        System.out.println("链表长度为：" + getListLength(head));
    }

    /**
     * 链表中指定位置插入node
     * @param head - 链表head节点
     * @param insertNode - 待插入节点
     * @param position - 待插入位置
     * @return
     */
    public static Node insertNode(Node head, Node insertNode, int position) {
        if (null == head){//当前没有链表
            return insertNode;
        }
        int size = getListLength(head);
        if (position < 0 || position > size + 1){//越界
            return null;
        }
        //插入头部
        if (position == 1){
            insertNode.next = head;
            head = insertNode;
            return head;
        }

        Node prevNode = head;
        int i = 1;
        while (i < position-1) {//遍历到position的前一个节点
           prevNode = prevNode.next;
           i++;
        }
        if (null == prevNode){
            return null;
        }

        insertNode.next = prevNode.next;
        prevNode.next = insertNode;
        return head;
    }

    public static ListNode insertNodeForBlog(ListNode head, ListNode insertNode, int position) {
        if (null == head){//当前没有链表
            return insertNode;
        }
        int size = ListNodeInit.getListLength(head);
        if (position < 0 || position > size + 1){//越界
            return null;
        }
        //插入头部
        if (position == 1){
            insertNode.next = head;
            head = insertNode;
            return head;
        }

        ListNode prevNode = head;
        int i = 1;
        while (i < position-1) {//遍历到position的前一个节点
            prevNode = prevNode.next;
            i++;
        }
        if (null == prevNode){
            return null;
        }

        insertNode.next = prevNode.next;
        prevNode.next = insertNode;
        return head;
    }


    /**
     * 删除指定位置节点
     * @param head - 当前链表头节点
     * @param position - 删除位置
     * @return
     */
    public static Node deleteNode(Node head,int position) {
        if (null == head){//链表为空
            return null;
        }
        int length = getListLength(head);
        if (position <= 0 || position > length){//删除位置无效
            return null;
        }

        //删除头部节点
        Node pNode = head;
        if (position == 1){
            head.next = null;//断开原head，不断也行，断开会更好的被GC
            return pNode.next;//设置新head
        }

        int count = 1;
        while (count < position - 1){//找到删除节点的前一个节点
            pNode = pNode.next;
            count++;
        }

        Node deleteNode = pNode.next;
        pNode.next = deleteNode.next;
        deleteNode.next = null;//断开删除节点和链表的联系，不断也行，断开会更好的被GC
        return head;
    }



    public static ListNode deleteNodeForBlog(ListNode head,int position) {
        if (null == head){//链表为空
            return null;
        }
        int length = ListNodeInit.getListLength(head);
        if (position <= 0 || position > length){//删除位置无效
            return null;
        }

        //删除头部节点
        ListNode pNode = head;
        if (position == 1){
            head.next = null;//断开原head，不断也行，断开会更好的被GC
            return pNode.next;//设置新head
        }

        int count = 1;
        while (count < position - 1){//找到删除节点的前一个节点
            pNode = pNode.next;
            count++;
        }

        ListNode deleteNode = pNode.next;
        pNode.next = deleteNode.next;
        deleteNode.next = null;//断开删除节点和链表的联系，不断也行，断开会更好的被GC
        return head;
    }



    public static int getListLength(Node head){
        int length = 0;
        while (null != head){
            length++;
            head = head.next;
        }
        return length;
    }


    static class Node {
        final int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
}
