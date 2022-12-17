package com.lonely.wolf.note.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/11/22
 * @since jdk1.8
 */
public class $10_LeftNode {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);

        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);
        treeNode.right.right.right = new TreeNode(7);
        System.out.println(findBottomLeftValueByBFS(treeNode));


    }


    /**
     * Leetcode 513 找树左下角的值。
     *
     * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。假设二叉树中至少有一个节点。
     *
     * 解题思路1：层次遍历（广度优先），最后一层第一个就是需要找到的数据。
     * 解题思路2：层次遍历（广度优先），每一层都从右往左遍历，最后一个元素就是左边第一个元素
     * @param root
     * @return
     */
    public static int findBottomLeftValueByBFS(TreeNode root) {
        if (null == root){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int size = 1;
        TreeNode res = root;
        while (!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            if (null != node.left){
                queue.addLast(node.left);
            }
            if (null != node.right){
                queue.addLast(node.right);
            }
            size--;
            if (size == 0 && !queue.isEmpty()){
                size = queue.size();
                res = queue.getFirst();
            }
        }
        return res.val;
    }

    /**
     * Leetcode 513 找树左下角的值。
     *
     * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。假设二叉树中至少有一个节点。
     *
     * 解题思路2：深度优先遍历
     *
     *
     * 因为我们先遍历左子树，然后再遍历右子树，所以对同一高度的所有节点，最左节点肯定是最先被遍历到的。
     *
     *
     * @param root
     * @return
     */
    static int curVal = 0;
    static int curHeight = 0;
    public static int findBottomLeftValueByDFS(TreeNode root) {
        dfs(root,0);
        return curVal;

    }
    private static void dfs(TreeNode root, int height) {
        if (null == root){
            return;
        }
        height++;//高度+1
        dfs(root.left,height);
        dfs(root.right,height);

        //这里一定会在最后一层满足条件，递归回归的时候，height一定小于curHeight
        //而因为我们先遍历左节点，所以最先拿到的一定是左节点的值
        if (height > curHeight){//树的高度大于当前遍历的高度
            curHeight = height;
            curVal = root.val;
        }

    }


    /**
     * Leetcode404 左叶子之和
     *
     * 给定二叉树的根节点 root ，返回所有左叶子之和。
     *
     * 左子节点：null != node.left && null == node.left.left && null == node.left.right
     * null == node.left.left && null == node.left.right 说明当前节点是叶子节点
     *
     * 解题思路1：深度优先
     * @param root
     * @return
     */
    public static int sumOfLeftLeavesByDFS(TreeNode root) {
        if (null == root){
            return 0;
        }
        return sumNode(root);
    }

    private static int sumNode(TreeNode node) {
        int ans = 0;
        if (null != node.left){
            ans += isLeafNode(node.left) ? node.left.val : sumNode(node.left);
        }
        if (null != node.right && !isLeafNode(node.right)){
            ans += sumNode(node.right);
        }
        return ans;
    }

    public static boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }



    /**
     * Leetcode404 左叶子之和
     *
     * 给定二叉树的根节点 root ，返回所有左叶子之和。
     *
     * 左子节点：null != node.left && null == node.left.left && null == node.left.right
     * null == node.left.left && null == node.left.right 说明当前节点是叶子节点
     *
     * 解题思路2：广度优先
     * @param root
     * @return
     */
    public static int sumOfLeftLeavesByBFS(TreeNode root) {
        if (null == root){
            return 0;
        }
        int ans = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            if (null != node.left){
                if (isLeafNode(node.left)){
                    ans += node.left.val;
                }else{
                    queue.add(node.left);
                }
            }
            if (null != node.right){
                queue.add(node.right);
            }
        }
        return ans;
    }


    /**----------------------------------------------以下为复盘练习使用方法-----------------------------------------*/


}
