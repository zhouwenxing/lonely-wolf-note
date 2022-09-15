package com.lonely.wolf.note.exercise.homework2;

/**
 * 第一题：通过三次反转实现链表旋转
 * 参考链表讲义2.4.3，实现旋转有一种是将整个链表反转变成{5,4,3,2,1}，
 * 然后再将前K和N-K两个部分分别反转，也就是分别变成了{4,5}和{1,2,3},之后合并再一起就是需要的链表{4,5,1,2,3}了
 * 请你编程实现该功能
 * 考察内容:链表反转
 * <p>
 * 要求：
 * 1.必须同时实现rotateRight()和reverse()两个方法来完成功能，后者只完成链表反转，前者可以灵活实现，但是必须调用三次后者
 * 2.可以将原始链表拆分成两个子链表，但是不得创建新链表
 * 3.rotateRight()和reverse()的入参和返回值你可以根据自己的需要设置，
 * 4.请保证提交的代码能执行，不能执行或者执行结果不对，视为0分
 * 5.最晚提交时间：2022年1月3日晚12点，过期提交作废
 * 6.请将homework.task2下的三个题目做完后一起打包发到荣荣邮箱，包名必须有你的编号（参考编号列表），如果不按规定找不到你，视为0分
 * 7.出题不易，一起都为了你的学习，请不要随便外传题目
 */
public class RotateRight {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Node head = initLinkedList(a);

        Node newHead = rotateRight(head,4);
//        这里应该输出 4 5 1 2 3
        System.out.println(printList(newHead));

    }

    /**
     * 通过rotateRight()方法和reverse()两个方法实现功能
     *
     * @param head
     * @return
     */
    private static Node rotateRight(Node head,int k) {
        if (null == head || null == head.next || k <= 0){
            return head;
        }

        Node temp = head;
        int len = getListLength(temp);//获取长度
        k = k % len;
        if (k == 0){//0 则表示不反转
            return head;
        }

        Node newHead = reverse(head);//第一次，全链表反转

        Node sentry = new Node(-1);
        sentry.next = newHead;

        Node pre = sentry;
        Node end = sentry;
        for (int i=0;i < k;i++){
            end = end.next;
        }
        Node start = pre.next;
        Node next = end.next;//下一段反转的头节点
        end.next = null;//断开
        pre.next = reverse(start);//前 k 个元素反转
        start.next = reverse(next);// 后 n-k 个元素反转

        return sentry.next;
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


    private static int getListLength(Node head){
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
    public static String printList(Node head) {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.val).append("\t");
            current = current.next;
        }
        return sb.toString();
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
