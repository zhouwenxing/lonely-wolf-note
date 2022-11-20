package com.lonely.wolf.note.tree;

import java.math.BigDecimal;
import java.util.*;

/**
 * 树 层次遍历（广度优先）相关变形题
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/1/11
 * @since jdk1.8
 */
public class $3_TraverseTreeByBFS2 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        TreeNode left = new TreeNode(-1);
        treeNode.left = left;
        List<Integer> result = largestValuesForEveryLevel(treeNode);
        System.out.println(result.size());

        System.out.println(10.0/3.0);

    }


    /**
     * LeetCode 515 在每个树⾏中找最⼤值
     *
     * 给定⼀棵⼆叉树的根节点 root ，请找出该⼆叉树中每⼀层的最⼤值
     *
     * @param rootNode
     * @return
     */
    public static List<Integer> largestValuesForEveryLevel(TreeNode rootNode){
        if (null == rootNode){
            return Collections.EMPTY_LIST;
        }
        List<Integer> largestValues = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()){
            int size = queue.size();
            int levelMaxNum = Integer.MIN_VALUE;
            for (int i=0;i<size;i++){
                TreeNode currNode = queue.removeFirst();
                levelMaxNum = Math.max(levelMaxNum,currNode.val);
                if (null != currNode.left){
                    queue.addLast(currNode.left);
                }
                if (null != currNode.right){
                    queue.addLast(currNode.right);
                }
            }
            largestValues.add(levelMaxNum);
        }
        return largestValues;
    }


    /**
     * LeetCode 637 在每个树⾏中找平均值
     *
     * 要求给定⼀个⾮空⼆叉树, 返回⼀个由每层节点平均值组成的数组
     *
     * @param rootNode
     * @return
     */
    public static List<BigDecimal> avgValueForEveryLevelBigDecimal(TreeNode rootNode){
        if (null == rootNode){
            return Collections.EMPTY_LIST;
        }
        List<BigDecimal> avgValues = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()){
            int size = queue.size();
            BigDecimal sum = new BigDecimal("0");
            for (int i=0;i<size;i++){
                TreeNode currNode = queue.removeFirst();
                sum = sum.add(new BigDecimal(currNode.val + ""));
                if (null != currNode.left){
                    queue.addLast(currNode.left);
                }
                if (null != currNode.right){
                    queue.addLast(currNode.right);
                }
            }
            avgValues.add(sum.divide(new BigDecimal(size + ""),2,BigDecimal.ROUND_HALF_DOWN));
        }
        return avgValues;
    }

    public static List<Double> avgValueForEveryLevelDouble(TreeNode root){
        if (null == root){
            return Collections.EMPTY_LIST;
        }
        List<Double> avgValues = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0D;
            for (int i=0;i<size;i++){
                TreeNode currNode = queue.removeFirst();
                sum +=currNode.val;
                if (null != currNode.left){
                    queue.addLast(currNode.left);
                }
                if (null != currNode.right){
                    queue.addLast(currNode.right);
                }
            }
            avgValues.add(sum/size);
        }
        return avgValues;
    }


    /**
     * LeetCode 199 ⼆叉树的右视图
     *
     * 给定⼀个⼆叉树的 根节点 root，想象⾃⼰站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root){
        if (null == root){
            return Collections.EMPTY_LIST;
        }
        List<Integer> rightSideValues = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                TreeNode currNode = queue.removeFirst();
                if (null != currNode.left){
                    queue.addLast(currNode.left);
                }
                if (null != currNode.right){
                    queue.addLast(currNode.right);
                }
                if (i == size - 1){
                    rightSideValues.add(currNode.val);
                }
            }
        }
        return rightSideValues;
    }


    /**----------------------------------------------以下为复盘练习使用方法-----------------------------------------*/
    public static List<Integer> testLargestValuesForEveryLevel(TreeNode root){
        List<Integer> data = new ArrayList<>();
        if (null == root){
            return data;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = queue.size();
        int levelMaxNum = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            levelMaxNum = Math.max(levelMaxNum,node.val);
            if (null != node.left){
                queue.add(node.left);
            }
            if (null != node.right){
                queue.add(node.right);
            }
            size--;
            if (size == 0){
                data.add(levelMaxNum);
                levelMaxNum = Integer.MIN_VALUE;
                size = queue.size();
            }
        }
        return data;
    }
}
