package com.lonely.wolf.note.list;

import jdk.nashorn.internal.ir.LiteralNode;

import java.util.Stack;

/**
 * 判断⼀个链表是否为回⽂链表
 *
 * 链表：12321即为回文链表
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/12/23
 * @since jdk1.8
 */
public class $4_PalindromicList {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,2,1};
        int[] arr2 = {1,2,2,1};
        System.out.println("【数组】判断法：" + isPalindromicByArr(ListNodeInit.initLinkedList(arr1)));
        System.out.println("【数组】判断法：" + isPalindromicByArr(ListNodeInit.initLinkedList(arr2)));

        System.out.println("【全链表入栈】判断法：" + isPalindromicByFullStack(ListNodeInit.initLinkedList(arr1)));
        System.out.println("【全链表入栈】判断法：" + isPalindromicByFullStack(ListNodeInit.initLinkedList(arr2)));

        System.out.println("【半链表入栈】判断法：" + isPalindromicByHalfStack(ListNodeInit.initLinkedList(arr1)));
        System.out.println("【半链表入栈】判断法：" + isPalindromicByHalfStack(ListNodeInit.initLinkedList(arr2)));

        System.out.println("【全链表反转】判断法：" + isPalindromicByReverseFullList(ListNodeInit.initLinkedList(arr1)));
        System.out.println("【全链表反转】判断法：" + isPalindromicByReverseFullList(ListNodeInit.initLinkedList(arr2)));

        System.out.println("【半链表反转】判断法：" + isPalindromicByReverseHalfList(ListNodeInit.initLinkedList(arr1)));
        System.out.println("【半链表反转】判断法：" + isPalindromicByReverseHalfList(ListNodeInit.initLinkedList(arr2)));

        System.out.println("【递归】判断法：" + isPalindromicByRecursion(ListNodeInit.initLinkedList(arr1)));
        System.out.println("【递归】判断法：" + isPalindromicByRecursion(ListNodeInit.initLinkedList(arr2)));
    }


    /**
     * 方法1：将链表存在数组，然后分别从数组首尾开始遍历，都相等则为回文链表
     *
     * 注意：如果只有一个元素默认也是回文元素
     *
     * @param head - 链表头节点
     * @return
     */
    public static boolean isPalindromicByArr(ListNode head){
        if (null == head){
            return false;
        }
        if (null == head.next){
            return true;
        }
        int len = ListNodeInit.getListLength(head);//获取链表长度
        ListNode[] arr = new ListNode[len];

        //存入数组
        ListNode curr = head;
        int count=0;
        while (null != curr){
            arr[count++] = curr;
            curr = curr.next;
        }

        int i=0;
        int j = len-1;
        while (arr[i].getVal() == arr[j].getVal() && i<=j){
           if ((++i)>len-1 || (--j)< 0){
               break;
           }
        }
        if (i<=j){
            return false;
        }
        return true;
    }

    /**
     * 方法2，第1次遍历链表存入栈；第2次遍历链表同时出栈，并进行对比，遍历到一半如果全部相等即可判定为回文链表
     *
     * 注意：如果只有一个元素默认也是回文元素
     *
     * @param head - 链表头节点
     * @return
     */
    public static boolean isPalindromicByFullStack(ListNode head){
        if (null == head){
            return false;
        }
        if (null == head.next){
            return true;
        }
        ListNode curr = head;
        Stack<ListNode> stack = new Stack<>();
        int len = pushStackAndGetLength(stack,curr);//入栈同时计算链表长度
        int half = len / 2;

        int count = 0;
        while (count <= half){
            if (stack.pop().getVal() != curr.getVal()){
                return false;
            }
            curr = curr.next;
            count++;
        }
        return true;
    }


    /**
     * 方法3，类似方法2，只不过这次选择的是一半元素入栈，所以需要先遍历链表获得链表的总长度
     *
     * 注意：如果只有一个元素默认也是回文元素
     *
     * @param head - 链表头节点
     * @return
     */
    public static boolean isPalindromicByHalfStack(ListNode head){
        if (null == head){
            return false;
        }
        if (null == head.next){
            return true;
        }
        ListNode curr = head;

        int len = ListNodeInit.getListLength(curr);
        int half = len / 2;
        int remain = len % 2;

        Stack<ListNode> stack = new Stack<>();

        int count = 1;
        while (count <= half){ //遍历一半，并且入栈
            stack.push(curr);
            curr = curr.next;
            count++;
        }

        if (remain == 1){//跳过奇数部分
            count++;
            curr = curr.next;
        }

        while (count <= len){ //开始出栈
            if (curr.getVal() != stack.pop().getVal()){
                return false;
            }
            curr = curr.next;
            count++;
        }
        return true;
    }



    /**
     * 方法4：反转链表法
     *
     * 先创建⼀个链表 newList，然后原始链表 oldList 的元素值逆序保存到 newList 中，然后重新遍
     * 历 newList 和 oldList，同时⽐较元素的值，只要有⼀个位置的元素值不⼀样，就不是回⽂链表
     *
     * 注意：如果只有一个元素默认也是回文元素
     *
     * @param head - 链表头节点
     * @return
     */
    public static boolean isPalindromicByReverseFullList(ListNode head){
        if (null == head){
            return false;
        }
        if (null == head.next){
            return true;
        }
        ListNode curr1 = head;
        ListNode newHead = new ListNode(head.val);//创建新链表
        ListNode newHeadCurr = newHead;
        while (curr1.next != null){
            newHeadCurr.next = new ListNode(curr1.next.val);
            newHeadCurr = newHeadCurr.next;
            curr1 = curr1.next;
        }
        //反转新链表
        ListNode pre = null;
        ListNode curr2 = newHead;
        while (null != curr2){
            ListNode next = curr2.next;
            curr2.next = pre;
            pre = curr2;
            curr2 = next;
        }
        newHead = pre;

        ListNode _curr1 = head;
        ListNode _curr2 = newHead;
        while (null != _curr1){//可以优化只遍历一半
            if (_curr1.val != _curr2.val){
                return false;
            }
            _curr1 = _curr1.next;
            _curr2 = _curr2.next;
        }
        return true;
    }


    /**
     * 方法5：反转链表法
     *
     * 对方法4进行的优化，其实不需要全部遍历，只需要反转一半即可。
     *
     * 具体步骤：
     * 1、先遍历⼀遍链表，得到⻓度。
     * 2、重新遍历链表，⼀边遍历，⼀边将链表反转，到达⼀半的位置后，就不再反转。
     * 3、开始⽐较两个链表，只要有⼀个元素不⼀样，就不是回⽂链表。
     *
     *
     * 注意：如果只有一个元素默认也是回文元素
     *
     * @param head - 链表头节点
     * @return
     */
    public static boolean isPalindromicByReverseHalfList(ListNode head){
        if (null == head){
            return false;
        }
        if (null == head.next){
            return true;
        }

        int len = ListNodeInit.getListLength(head);
        int half = len / 2;
        int remain = len % 2;

        ListNode pre = null;
        ListNode curr = head;
        int count = 1;
        while ((count++) <= half){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        if (remain == 1 && null != curr){//奇数个节点时，跳过中间节点
            curr = curr.next;
        }
        ListNode _curr1 = pre;
        ListNode _curr2 = curr;
        while (null != _curr1){
            if (_curr1.val != _curr2.val){
                return false;
            }
            _curr1 = _curr1.next;
            _curr2 = _curr2.next;
        }
        return true;
    }


    /**
     * 方法6：反转链表法 + 快慢双指针法
     *
     * 依然是对方法4进行的优化，但是不需要获取长度，利用快慢双指针法
     *
     * 具体步骤：
     * 1、定义 slow 和 fast 两个指针，slow 走 1 步，fast 走 2 步。
     * 2、一边遍历一边反转，当 fast 走到尾部则停止反转
     * 3、将反转后的链表和 slow 指针后的链表开始比较
     *
     * 注意：如果只有一个元素默认也是回文元素
     *
     * @param head - 链表头节点
     * @return
     */
    public static boolean isPalindromicByReverseHalfListAndDoublePoint(ListNode head){
        if (null == head){
            return false;
        }
        if (null == head.next){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode start = head;//反转后的新链表

        ListNode end = null;
        while (null != fast && fast.next != null){
            start = slow;
            slow = slow.next;
            fast = fast.next.next;

            start.next = end;
            end = start;
        }
        //防止奇数的情况，此时 slow 刚好在正中间，而奇数时，中间是共用的，不需要比较，如：1-》2-》3-》2-》1
        // fast 走到最后 的 1时，slow 正好在 3，而链表只反转了 1->2，所以 slow需要继续往后走一步
        if (null != fast){
            slow = slow.next;
        }

        while (null != slow && null != start){
            if (slow.val != start.val){
                return false;
            }
            slow = slow.next;
            start = start.next;
        }
        return true;
    }


    /**
     * 递归法，参考下面的倒序打印链表思想
     * @param head
     * @return
     */
    private static ListNode TEMP;
    public static boolean isPalindromicByRecursion(ListNode head){
        if (null == head){
            return false;
        }
        if (null == head.next){
            return true;
        }
        TEMP = head;
        return check(head);
    }

    private static boolean check(ListNode head){
        if (null == head){
            return true;
        }
        boolean res = check(head.next) && head.val == TEMP.val;
        TEMP = TEMP.next;
        return res;
    }


    /**
     * 倒序打印链表
     * @param head
     */
    private void printListNode(ListNode head){
        if (null == head){
            return;
        }
        printListNode(head.next);
        System.out.println(head.val);
    }

    private static int pushStackAndGetLength(Stack<ListNode> stack, ListNode head) {
        int length = 0;
        while (null != head){
            stack.push(head);//压栈
            length++;
            head = head.next;
        }
        return length;
    }

    /**----------------------------------------------------以下为复盘练习使用方法---------------------------------------------*/

}
