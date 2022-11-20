package com.lonely.wolf.note.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 二叉树路径相关问题
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/11/16
 * @since jdk1.8
 */
public class $7_TraverseTreeForPath {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
//        treeNode.right = new TreeNode(7);
//        treeNode.left.left = new TreeNode(1);
//        treeNode.left.right = new TreeNode(3);
//        treeNode.right.left = new TreeNode(6);
//        treeNode.right.right = new TreeNode(9);
        System.out.println(hasPathSum(treeNode,1));


    }


    /**
     * LeetCode 257 二叉树的所有路径
     * 给你一颗二叉树，按任意顺序，返回所有从根节点到叶子节点的路径
     * @param root
     * @return
     */
    public static List<String> binaryTreePaths(TreeNode root){
        List<String> paths = new ArrayList<>();
        if (null == root){
            return paths;
        }
        String path = "";
        findPaths(root,path,paths);
        return paths;
    }

    private static void findPaths(TreeNode node, String path, List<String> paths) {
        if (null == node){
            return;
        }
        if (null == node.left && null == node.right){
            paths.add(path + node.val);
            return;
        }
        findPaths(node.left,path + node.val + "->",paths);//左节点
        findPaths(node.right,path + node.val + "->",paths);//右节点
    }



    /**
     * LeetCode 112 路径总和
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
     * 判断该树中是否存在 根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和 targetSum 。
     * 如果存在，返回 true ；否则，返回 false 。
     *
     * PS：叶子节点 是指没有子节点的节点。
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int targetSum){
        if (null == root){
            return false;
        }
        if (null == root.left && null == root.right){
            return targetSum - root.val == 0;
        }
        return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right,targetSum - root.val);
    }


    /**
     * LeetCode 112 的拓展，找到后将所有符合条件的路径打印出来
     * @param root
     * @param targetSum
     * @return
     */
    public static List<List<Integer>> hasPathSum2(TreeNode root, int targetSum){
        List<List<Integer>> paths = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        
        checkPath(paths,queue,root,targetSum);
        return paths;
    }

    private static void checkPath(List<List<Integer>> paths, Deque<Integer> queue, TreeNode node,int targetSum) {
        if (null == node){
            return;
        }
        queue.addLast(node.val);
        if (null == node.left && null == node.right && targetSum - node.val == 0){
            paths.add(new LinkedList<>(queue));
        }
        checkPath(paths,queue,node.left,targetSum - node.val);
        checkPath(paths,queue,node.right,targetSum - node.val);
        queue.pollLast();//删除最后一个节点
    }


    /**----------------------------------------------以下为复盘练习使用方法-----------------------------------------*/


}
