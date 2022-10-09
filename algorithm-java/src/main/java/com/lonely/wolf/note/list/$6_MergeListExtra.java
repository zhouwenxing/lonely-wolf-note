package com.lonely.wolf.note.list;

/**
 * LeetCode 1669：给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。请你将 list1 中第 a 个节点
 * 到第 b 个节点删除，并将list2 接在被删除节点的位置。
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/23
 * @since jdk1.8
 */
public class $6_MergeListExtra {
    public static void main(String[] args) {
//        int[] arr1 = {1,2,3,4,5,6,7,8,9};
//        int[] arr2 = {2,6,9};
//
//        ListNode listNode1 = ListNodeInit.initLinkedList(arr1);
//        ListNode listNode2 = ListNodeInit.initLinkedList(arr2);
//
//        ListNode resultNode = mergeListInBetween(listNode1,listNode2,1,2);
//        System.out.println(resultNode);

        int[] arr3 = {0,1,2,3,4,5};
        int[] arr4 = {100000,100001,100002};
        ListNode listNode3 = ListNodeInit.initLinkedList(arr3);
        ListNode listNode4 = ListNodeInit.initLinkedList(arr4);
//        System.out.println(ListNodeInit.toString(mergeListInBetween(listNode3,listNode4,3,4)));
        System.out.println(ListNodeInit.toString(testMergeListInBetween(listNode3,listNode4,3,4)));
    }


    /**
     * 将listNode1中 [a,b)区间删除，并将 listNode2 接入,下标从 1 开始
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

    /**----------------------------------------------------以下为复盘练习使用方法---------------------------------------------*/

    /**
     * [a,b]区间删除，下标从 0 开始
     * @param list1
     * @param list2
     * @param a
     * @param b
     * @return
     */
    public static ListNode testMergeListInBetween(ListNode list1,ListNode list2,int a,int b){
        if (null == list1 || null == list2 || a <= 0 || b <= 0 || a > b){
            return null;
        }
        ListNode pre = null;
        ListNode end = null;
        int count = 0;
        ListNode sentry = new ListNode(-1);
        sentry.next = list1;
        ListNode curr = sentry;
        while (null != curr && count <= a){
            pre = curr;
            curr = curr.next;
            end = curr;
            count++;
        }

        while (null != curr && count <= (b+1)){
            curr = curr.next;
            end = curr;
            count++;
        }
        pre.next = list2;
        ListNode curr2 = list2;
        while (null != curr2.next){
            curr2 = curr2.next;
        }
        curr2.next = end;
        return sentry.next;
    }
}
