package com.lonely.wolf.note.tree;

import java.util.*;

/**
 * Leetcode 236 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/11/22
 * @since jdk1.8
 */
public class $9_FindCommonAncestor {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(9);
        treeNode.left.right = new TreeNode(6);
        treeNode.left.right.left = new TreeNode(8);
        treeNode.left.right.right = new TreeNode(5);

        treeNode.left.left.left = new TreeNode(12);
        treeNode.left.left.right = new TreeNode(15);

        TreeNode result = lowestCommonAncestor(treeNode,treeNode.left.right.right,new TreeNode(111));
        System.out.println(result.val);

    }


    /**
     * 解题思路1：递归
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root){
            return null;
        }
        if (root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (null == left && null == right){
            return null;
        }
        if (null !=left && null != right){
            return root;
        }
        return null == left ? right : left;
    }




    /**
     * 解题思路2：
     * 利用哈希表存储所有节点的父节点，然后将p或者q逐个往回找，形成一条链，再逐个和q及q的父节点进行匹配，直到匹配上
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestorByHash(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root){
            return null;
        }
        Map<Integer, TreeNode> parent = new HashMap<>();//存储父节点
        Set<Integer> visited = new HashSet<>();//存储其中一条链路

        //递归遍历，存储所有节点的父节点
        dfs(root,parent);

        //构建p的访问路径
        while (null != p){
            visited.add(p.val);
            p = parent.get(p.val);
        }

        //从p开始逐个往上遍历，并和visited进行比较，第一个相同的点即为最近共同节点
        while (null != q){
            if (visited.contains(q.val)){//命中则返回
                return q;
            }
            q = parent.get(q.val);//未命中继续往上遍历
        }
        return null;
    }

    private static void dfs(TreeNode root, Map<Integer, TreeNode> parent) {
        if (null == root){
            return;
        }
        if (null != root.left){
            parent.put(root.left.val,root);
        }
        if (null != root.right){
            parent.put(root.right.val,root);
        }
        dfs(root.left,parent);
        dfs(root.right,parent);
    }


    /**----------------------------------------------以下为复盘练习使用方法-----------------------------------------*/


}
