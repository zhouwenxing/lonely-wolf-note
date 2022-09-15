package com.lonely.wolf.note.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定⼀个链表，判断链表中是否有环。假如有环，如何判断环的位置
 *
 * 示例：
 * 输⼊：head = [3,2,0,-4], pos = 1  输出：true
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/25
 * @since jdk1.8
 */
public class $16_CircleList {
    public static void main(String[] args) {
//        int[] arr1 = {3,2,0,4};
//        ListNode listNode1 = ListNodeInit.initLinkedList(arr1);
//        listNode1.next.next.next.next = listNode1.next;
//        ListNode resultNode1 = findCyclePosition(listNode1);
//        System.out.println(null == resultNode1 ? null : resultNode1.getVal());//输出  2

//        int[] arr2 = {1,2};
//        ListNode listNode2 = ListNodeInit.initLinkedList(arr2);
//        listNode2.next.next = listNode2;
//        ListNode resultNode2 = findCyclePosition(listNode2);
//        System.out.println(null == resultNode2 ? null : resultNode2.getVal());//输出 1


        int[] arr3 = {1};
        ListNode listNode3 = ListNodeInit.initLinkedList(arr3);
        ListNode resultNode3 = findCyclePosition(listNode3);
        System.out.println(null == resultNode3 ? null : resultNode3.getVal());//输出 null

    }


    /**
     * 通过 hash 判断
     *
     * 将节点依次存入 hash，如果发生碰撞，则说明存在环
     *
     * @param head
     * @return
     */
    public static boolean isCircleByHash(ListNode head){
        if (null == head){
            return false;
        }

        Set<ListNode> set = new HashSet<>();
        while (null != head){
            if (set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }


    /**
     * 通过快慢指针判断。
     *
     * slow 走 1步，fast 走 2 步，只要存在环，则一定在某一个地方 slow=fast
     *
     * @param head
     * @return
     */
    public static boolean isCircleByTwoPoint(ListNode head){
        if (null == head || null == head.next){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && null != fast.next){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }

        }
        return false;
    }



    /**
     * 通过快慢指针判断。
     *
     * 当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。
     * 起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。
     * 最终，它们会在入环点相遇。
     *
     * @param head
     * @return
     */
    public static ListNode findCyclePosition(ListNode head){
        if (null == head || null == head.next){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast && null != fast.next){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                ListNode ptr = head;
                while (ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
