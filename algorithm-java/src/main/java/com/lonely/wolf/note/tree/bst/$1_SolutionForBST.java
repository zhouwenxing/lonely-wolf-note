package com.lonely.wolf.note.tree.bst;

import com.alibaba.fastjson.JSONObject;
import com.lonely.wolf.note.tree.BuildBinaryTree;
import com.lonely.wolf.note.tree.TreeNode;

import java.util.*;

/**
 * BST（Binary Search Tree）二叉搜索树
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 *  所有左子树和右子树自身必须也是二叉搜索树。
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/12/14
 * @since jdk1.8
 */
public class $1_SolutionForBST {
    public static void main(String[] args) {
        System.out.println(11);
    }


    /**
     * Leetcode 700. 二叉搜索树中的搜索
     * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
     * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null。
     *
     * @param root
     * @param val
     * @return
     */
    public static TreeNode searchBST(TreeNode root, int val) {
        if (null == root || root.val == val){
            return root;
        }
        if (root.val > val){
            return searchBST(root.left,val);
        }
        return searchBST(root.right,val);
    }


    /**
     * Leetcode 98：验证二叉搜索树
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     *
     * 有效二叉搜索树定义如下：
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * 解题思路：这道题不能仅仅判断左右子树和父节点的大小关系，还需要注意，根节点应大于左子树中所有节点，而小于右子树中所有节点
     * 如下题解法就是一个错误的解法，[5,4,6,null,null,3,7]中因为3小于5，所以并不是二叉搜索树，但是此种解法会输出true
     *
     * @return
     */
    public static boolean Error_isValidBST(TreeNode root) {
        if (null == root){
            return true;
        }
        boolean left = false;
        if (null == root.left || root.left.val < root.val){
            left = true;
        }

        boolean right = false;
        if (null == root.right || root.right.val > root.val){
            right = true;
        }
        if (left && right){
            return Error_isValidBST(root.left) && Error_isValidBST(root.right);
        }else {
            return false;
        }
    }


    /**
     * 解题思路：注意将范围保持在一个区间
     * @param root
     * @return
     */
    public static boolean isValidBSTByRecusion(TreeNode root) {
        return isValidBSTByRecusion(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private static boolean isValidBSTByRecusion(TreeNode node, long lower, long upper) {
        if (null == node){
            return true;
        }
        if (node.val <= lower || node.val >= upper){
            return false;
        }
        return isValidBSTByRecusion(node.left,lower,node.val) &&
                isValidBSTByRecusion(node.right,node.val,upper);
    }

    /**
     * 中序遍历法解题：有效二叉树，中序遍历后得到的数组一定是有序的，所以只需要判断当前遍历的节点大于前一个节点即可
     * @param root
     * @return
     */
    public static boolean isValidBSTByTraversal(TreeNode root) {
        if (null == root){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        long pre = Long.MIN_VALUE;
        while (!stack.isEmpty() || null != node){
            while (null != node){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.val <= pre){
                return false;
            }
            pre = node.val;
            node = node.right;
        }
        return true;
    }


    /**
     * Leetcode 108. 将有序数组转换为二叉搜索树
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
     * 高度平衡 二叉树是一棵满足[每个节点的左右两个子树的高度差的绝对值不超过 1]的二叉树。
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return null;
    }
}
