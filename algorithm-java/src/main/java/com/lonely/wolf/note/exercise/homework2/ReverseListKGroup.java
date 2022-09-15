package com.lonely.wolf.note.exercise.homework2;

/**
 * 第三题：
 * 链表算法的菁华是反转问题，反转问题的珠峰是K个一组反转，请你参考讲义2.6.3实现个K个一组反转的功能
 * 下面给了10个数，请实现4个一组反转的功能，最后剩下不够一组的不用反转
 * 提示：
 * 你可以参考网上的材料和代码，只要你能理解，并且将下面的case运行出来就行
 * 要求：
 * 1.不得将元素放到数组或者栈等结构中，也不允许创建新链表，只允许操作链表
 * 2.请保证提交的代码能执行，不能执行或者执行结果不对，视为0分
 * 3.最晚提交时间：2022年1月3日晚12点，过期提交作废
 * 4.请将homework.task2下的三个题目做完后一起打包发到荣荣邮箱，包名必须有你的编号（参考编号列表），如果不按规定找不到你，视为0分
 * 5.出题不易，一起都为了你的学习，请不要随便外传题目
 */
public class ReverseListKGroup {

    public static void main(String[] args) {
        int[] score = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node head = initLinkedList(score);

        Node newHead = reverseKGroup(head);
//        这里应该输出 4 3 2 1 8 7 6 5 9 10，最后的9 10不足一个分组就不用反转
        System.out.println(printList(newHead));

    }

    /**
     * todo 在这里实现功能
     *
     * @param head
     * @return
     */
    private static Node reverseKGroup(Node head) {
        if (null == head || null == head.next){
            return head;
        }

        int tlen = getListLength(head);
        int reverseNum = tlen / 4;

        Node sentry = new Node(-1);
        sentry.next = head;

        Node pre = sentry;
        Node next = pre.next;
        Node curr;
        for (int n=1;n <= reverseNum;n++){
            int i=1;
            curr = next;
            Node start = curr;
            while (null != curr && i < 4){
                curr = curr.next;
                i++;
            }
            if (null != curr){
                next = curr.next;//记录下一次开始反转的头节点
                curr.next = null;//断开
            }else{
                next = null;
            }
            pre.next = reverse(start);//左边和反转后链表接上
            pre = start;//记录接上反转后链表的尾节点，下一次接入使用
        }
        pre.next = next;//接上最后一段
        return sentry.next;
    }


    /**
     * 输出链表
     *
     * @param head 头节点
     */
    public static String printList(Node head) {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.val).append("\t");
            current = current.next;
        }
        return sb.toString();
    }


    private static int getListLength(Node head){
        int length = 0;
        while (null != head){
            length++;
            head = head.next;
        }
        return length;
    }

    /**
     * 链表反转
     */
    private static Node reverse(Node head) {
        if (null == head || null == head.next){//空或者只有一个节点无需反转
            return head;
        }
        Node pre = null;
        Node curr = head;
        while (null != curr){
            Node next = curr.next;//记录下一个节点
            curr.next = pre;//将当前节点 next 指向已经反转的节点
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 初始化链表
     *
     * @param array
     * @return
     */
    private static Node initLinkedList(int[] array) {
        Node head = null, cur = null;
        for (int i = 0; i < array.length; i++) {
            Node newNode = new Node(array[i]);
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

    static class Node {
        public int val;
        public Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }
}
