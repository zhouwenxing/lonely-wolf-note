package com.lonely.wolf.note.list;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 删除链表专题
 *
 *【1】LeetCode 237：删除某个链表中给定的（⾮末尾）节点。传⼊函数的唯⼀参数为要被删除的节点
 *【2】LeetCode 203：给你⼀个链表的头节点 head 和⼀个整数 val ，请你删除链表中所有满⾜ Node.val == val 的节点，并返回新的头节点 。
 *【3】LeetCode 19. 删除链表的倒数第 N 个节点
 *【4】LeetCode 1474. 删除链表 M 个节点之后的 N 个节点。
 *【5】LeetCode 83 存在⼀个按升序排列的链表，请你删除所有重复的元素，使每个元素只出现⼀次。
 *【6】LeetCode 82 存在⼀个按升序排列的链表，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
 *【7】LeetCode 1836. 从未排序链表中删除重复元素。
 *【8】LeetCode 1171 请你编写代码，反复删去链表中由总和值为 0 的连续节点组成的序列，直到不存在这样的序列为⽌。
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/24
 * @since jdk1.8
 */
public class $8_DeleteListNodeExtra {

    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,4,5,6,4,6};
//        ListNode listNode = ListNodeInit.initLinkedList(arr);
//        ListNode result = removeSpecialNode(listNode,1);
//        System.out.println(ListNodeInit.toString(result));
//
//        int[] arr2 = {1,2,3,4,4,5,6,4,6};
//        ListNode listNode2 = ListNodeInit.initLinkedList(arr2);
//        ListNode result2 = removeSpecialKNodeFromEndByLength(listNode2,1);//遍历移除倒数第 k 个元素
//        System.out.println(ListNodeInit.toString(result2));

        int[] arr3 = {1};
        ListNode listNode3 = ListNodeInit.initLinkedList(arr3);
        ListNode result3 = removeSpecialKNodeFromEndByStack(listNode3,2);//通过栈移除倒数第 k 个元素
        System.out.println(ListNodeInit.toString(result3));


//        int[] arr4 = {1,2,3};
//        ListNode listNode4 = ListNodeInit.initLinkedList(arr4);
//        ListNode result4 = removeSpecialKNodeFromEndByTwoPoint(listNode4,2);//通过双指针移除倒数第 k 个元素
//        System.out.println(ListNodeInit.toString(result4));


//        int[] arr5 = {1,1,2,3,4,5,6,6,6,7,7,8,9,10,10};
//        ListNode listNode5 = ListNodeInit.initLinkedList(arr5);
//        ListNode result5 = deleteDuplicates(listNode5);
//        System.out.println(ListNodeInit.toString(result5));


//        int[] arr6 = {1,1,2,2};
//        ListNode listNode6 = ListNodeInit.initLinkedList(arr6);
//        ListNode result6 = deleteRepeatElement(listNode6);
//        System.out.println(ListNodeInit.toString(result6));

//        int[] arr7 = {1,1,2,2,1,2,3};
//        ListNode listNode7 = ListNodeInit.initLinkedList(arr7);
//        ListNode result7 = deleteRepeatElementFromUnordererList(listNode7);
//        System.out.println(ListNodeInit.toString(result7));
    }


    /**
     * 给你⼀个链表的头节点 head 和⼀个整数 val ，请你删除链表中所有满⾜ Node.val == val 的节点，并返回新的头节点
     *
     * 示例
     * 输⼊：head = [1,2,6,3,4,5,6], val = 6 输出：[1,2,3,4,5]
     *
     * 解题思路
     * 头节点需要特殊处理，一般为了避免这种特殊处理，会引入一个哨兵节点来指向 head 节点，这样就不需要单独处理 head 节点
     *
     * @param head - 给点链表
     * @param val - 删除 val
     */
    public static ListNode removeSpecialNode(ListNode head,int val){
        if (null == head){
            return null;
        }
        ListNode sentry = new ListNode(-1);
        sentry.next = head;

        ListNode curr = sentry;
        while (null != curr.next){
            if (curr.next.getVal() == val){
                ListNode deleteNode = curr.next;
                curr.next = curr.next.next;
                deleteNode.next = null;//只是为了断开无用节点，其实可以不用写
            }else{
                curr = curr.next;
            }
        }
        return sentry.next;
    }


    /**
     * 给你⼀个链表，删除链表的倒数第 k 个结点，并且返回链表的头结点。
     *
     * 示例
     * 输⼊：head = [1,2,3,4,5], n = 2  输出：[1,2,3,5]
     *
     * 解题思路
     * 如果不考虑遍历链表次数，那么可以先遍历一次，得到链表长度n，然后：n-k+1 的位置就是需要删除的元素。
     * 同样的，我们引入哨兵节点
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode removeSpecialKNodeFromEndByLength(ListNode head,int k){
        ListNode sentry = new ListNode(-1);//哨兵节点
        sentry.next = head;

        int len = ListNodeInit.getListLength(sentry);

        int count = 1;
        ListNode curr = sentry;
        while (count < len - k){//不需要+1是因为引入了哨兵节点
            curr = curr.next;
            count++;
        }
        if (null == curr.next){
            curr.next = null;
        }else{
            curr.next = curr.next.next;
        }
        return sentry.next;
    }

    /**
     * 给你⼀个链表，删除链表的倒数第 k 个结点，并且返回链表的头结点。
     *
     * 示例
     * 输⼊：head = [1,2,3,4,5], n = 2  输出：[1,2,3,5]
     *
     * 解题思路
     * 先将元素全部压栈，然后弹出第 k 个的时候就是我们要删除的节点
     *
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode removeSpecialKNodeFromEndByStack(ListNode head,int k){
        if (null == head){
            return new ListNode(-999);
        }

        ListNode sentry = new ListNode(-1);//哨兵
        sentry.next = head;

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = sentry;
        while (null != curr){//入栈
            stack.push(curr);
            curr = curr.next;
        }

        int i=1;
        while (i <= k && !stack.isEmpty()){// stack.isEmpty 是防止 k 超标
            stack.pop();
            i++;
        }

        ListNode pre = sentry;
        if (!stack.isEmpty()){
            pre = stack.peek();
        }

        if (null == pre.next){
            pre.next = null;
        }else {
            pre.next = pre.next.next;
        }

        return sentry.next;
    }

    /**
     * 给你⼀个链表，删除链表的倒数第 k 个结点，并且返回链表的头结点。
     *
     * 示例
     * 输⼊：head = [1,2,3,4,5], n = 2  输出：[1,2,3,5]
     *
     * 解题思路
     * 如果考虑时间复杂度只能遍历一次，可以利用双指针
     * 定义 slow 和 fast 两个指针，fast 从 head 先⾛ k 步，然后 slow 再开始⾛，当 fast ⾛到队尾的时候，slow 就是要删除的节点的前一个节点
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode removeSpecialKNodeFromEndByTwoPoint(ListNode head,int k){
        if (null == head){
            return new ListNode(-999);
        }

        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        ListNode slow = sentry;
        ListNode fast = sentry;

        //fast指针先走k步
        int i=0;
        while (i<=k && null != fast){// null != fast 防止 k 超标
            fast = fast.next;
            i++;
        }

        //slow 和 fast 一起走，直到 fast 走到末尾
        while (null != fast){
            fast = fast.next;
            slow = slow.next;
        }

        if (null == slow.next){
            slow.next = null;
        } else {
            slow.next = slow.next.next;
        }
        ListNode newHead = sentry.next;
//        sentry.next = null;
        return newHead;
    }


    /**
     * 删除重复节点
     * 给定一个升序排列的链表的头节点 head ，请你删除所有重复的元素，使每个元素只出现⼀次 。返回同样按升序排列的结果链表。
     *
     * 解题思路
     * curr 指针指向头节点，然后开始遍历，因为链表有序，当发现等于curr，则移除，否则 cur指针后移
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (null == head){
            return head;
        }

        ListNode curr = head;

        while (null != curr.next){
            if (curr.val == curr.next.val){
                curr.next = curr.next.next;//删除节点，且 curr 不移动，继续往后比较
            }else{
                curr = curr.next;// curr 往后移
            }
        }
        return head;
    }


    /**
     * 删除重复节点
     * 给定一个升序排列的链表的头节点 head ，请你删除所有重复的元素（只要有重复的，一个都不保留），返回同样按升序排列的结果链表。
     *
     * 解题思路
     * 这个关键是重复节点都不要，所以就会涉及到可能会删除头节点，所以引入哨兵会方便处理。
     *
     * @param head
     * @return
     */
    public static ListNode deleteRepeatElement(ListNode head) {
        if (null == head){
            return head;
        }

        ListNode sentry = new ListNode(-1);
        sentry.next = head;

        ListNode curr = sentry;
        while (null != curr && null != curr.next && null != curr.next.next){
            if (curr.next.val == curr.next.next.val){
                int sameVal = curr.next.val;//相同值先记录
                curr.next = curr.next.next.next;//这一步可以省略，如果省略，下面的null!=curr条件可以省略
                while (null != curr && null != curr.next && curr.next.val == sameVal){//继续往后比较
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return sentry.next;
    }


    /**
     * 删除重复节点
     * 给定一个无序链表的头节点 head ，请你删除所有重复的元素（只要有重复的，一个都不保留），返回同样按升序排列的结果链表。
     *
     * 解题思路
     * 两个关键：1、重复节点都不要 2、链表是无序的
     * 因为链表无序，所以需要借助 hash 来进行存储元素出现的次数，所以需要遍历两次，一次存次数，一次开始移除元素
     *
     * @param head
     * @return
     */
    public static ListNode deleteRepeatElementFromUnordererList(ListNode head) {
        if (null == head){
            return head;
        }

        Map<Integer,Integer> map = new HashMap<>();
        ListNode curr = head;
        while (null != curr){
            if (map.containsKey(curr.val)){
                map.put(curr.val,map.get(curr.val) + 1);
            }else{
                map.put(curr.val,1);
            }
            curr = curr.next;
        }

        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        curr = sentry;//重置curr
        while (null != curr && null != curr.next){
            if (map.get(curr.next.val) > 1){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return sentry.next;
    }


    /**
     * 给定一个节点，删除他且假设给定的节点一定不是尾节点(力扣237)
     *
     * 解题思想
     * 这道题思路其实就是替换值，把下一个节点的值替换到删除节点，然后干掉下一个节点
     *
     * @param deleteNode
     */
    public static void deleteNodeWithNotHead(ListNode deleteNode) {
        deleteNode.val = deleteNode.next.val;
        deleteNode.next = deleteNode.next.next;
    }
}
