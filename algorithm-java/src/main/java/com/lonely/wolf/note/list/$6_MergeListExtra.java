package com.lonely.wolf.note.list;

/**
 * LeetCode1669题：给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。请你将 list1 中第 a 个节点
 * 到第 b 个节点删除，并将list2 接在被删除节点的位置。
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/23
 * @since jdk1.8
 */
public class $6_MergeListExtra {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9};
        int[] arr2 = {2,6,9};

        ListNode listNode1 = ListNodeInit.initLinkedList(arr1);
        ListNode listNode2 = ListNodeInit.initLinkedList(arr2);

        ListNode resultNode = mergeListInBetween(listNode1,listNode2,1,2);
        System.out.println(resultNode);
    }


    /**
     * 将listNode1中 [a,b)区间删除，并将listNode2接入
     * @param listNode1
     * @param listNode2
     * @param a
     * @param b
     * @return
     */
    public static ListNode mergeListInBetween(ListNode listNode1,ListNode listNode2,int a,int b){
        if (a >= b || null == listNode1 || a < 1){
            return null;
        }

        int length1 = ListNodeInit.getListLength(listNode1);
        if (b > length1){
            return null;
        }
        ListNode preNode = null;
        ListNode postNode = null;

        //找到a的前一个节点:preNode；找到b节点，即:postNode
        ListNode curr1 = listNode1;
        int i=1;
        while (i <= b){
            if (i == a -1){
                preNode = curr1;
            }
            postNode = curr1;
            curr1 = curr1.next;
            i++;
        }

        //找到list2的最后一个节点，即:postNode
        int j=0;
        ListNode postNode2 = null;
        ListNode curr2 = listNode2;
        while (null != curr2){
            postNode2 = curr2;
            curr2 = curr2.next;
        }

        //尝试接入，注意preNode可能为空
        if (null == postNode2){
            if (null == preNode){
                return postNode;
            }
            preNode.next = postNode;
        }else{
            postNode2.next = postNode;
            if (null == preNode){
               return listNode2;
            }
            preNode.next = listNode2;
        }
        return listNode1;
    }
}
