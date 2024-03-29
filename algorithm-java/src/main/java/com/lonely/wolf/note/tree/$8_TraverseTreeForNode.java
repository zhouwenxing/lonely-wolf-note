package com.lonely.wolf.note.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 二叉树节点相关问题
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/11/20
 * @since jdk1.8
 */
public class $8_TraverseTreeForNode {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
//        treeNode.right = new TreeNode(7);
//        treeNode.left.left = new TreeNode(1);
//        treeNode.left.right = new TreeNode(3);
//        treeNode.right.left = new TreeNode(6);
//        treeNode.right.right = new TreeNode(9);


    }


    /**
     * Leetcode 222：给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
     *
     * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
     * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 2的h次方个节点。
     *
     * 解题思路1：不考虑完全二叉树特征，完全按照普通二叉树深度优先方式来遍历计数
     *
     * @param root
     * @return
     */
    public static int countNodesByBFS(TreeNode root) {
        int total = 0;
        if (null == root){
            return total;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.removeLast();
            if (null != node.left){
                queue.add(node.left);
            }
            if (null != node.right){
                queue.add(node.right);
            }
            total++;
        }
        return total;
    }

    /**
     * 解题思路2：利用递归分别计算左右节点数最后再加上根节点数
     * @param root
     * @return
     */
    public static int countNodesByRecursion(TreeNode root) {
        if (null == root){
            return 0;
        }
        int leftNum = countNodesByRecursion(root.left);
        int rightNum = countNodesByRecursion(root.right);
        return leftNum + rightNum + 1;
    }


    /**
     * 解题思路2：利用完全二叉树特性，叶子节点只可能在最后两层。遍历左右两边得到高度：left和 right
     * case 1:left=right(最后一层满了)，那就是一颗满二叉树，那么节点数为：2的h次方（h为树高）
     * case 2：left!=right(最后一层不满)，那么叶子节点只在最左侧
     *
     * 官方解法按照二分查找法，不是很理解，先跳过。
     *
     * @param root
     * @return
     */
    public static int countNodes(TreeNode root) {
        if (null == root){
            return 0;
        }

        return 1;
    }



    /**----------------------------------------------以下为复盘练习使用方法-----------------------------------------*/


}
