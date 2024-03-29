package com.lonely.wolf.note.tree;

import com.alibaba.fastjson.JSONObject;
import com.lonely.wolf.note.list.ListNode;
import com.lonely.wolf.note.list.ListNodeInit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * BFS（Breath First Search）广度优先搜索
 * 二叉树广度优先问题，广度优先也称之为层次遍历，就是从上到下，从左到右一层一层遍历
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/1/5
 * @since jdk1.8
 */
public class $1_TraverseTreeByBFS {
    public static void main(String[] args) {
        TreeNode rootNode = BuildBinaryTree.buildBinaryTree();
        System.out.println("层级普通遍历二叉树1：" + traverseTreeLevel(rootNode));
        System.out.println("层级普通遍历二叉树2：" + testTraverseTreeLevel(rootNode));
        System.out.println("广度优先遍历-从顶向下1：" + traverseTreeGroupLevelFromTop(rootNode));
        System.out.println("广度优先遍历-从顶向下2：" + testTraverseTreeGroupLevelFromTop(rootNode));
        System.out.println("广度优先遍历-从底向上:" + traverseTreeGroupLevelFromBottom(rootNode));
        System.out.println("广度优先遍历-从顶向下-锯齿状1:" + traverseTreeGroupLevelZigzag(rootNode));
        System.out.println("广度优先遍历-从顶向下-锯齿状2:" + testTraverseTreeGroupLevelZigzag(rootNode));
        System.out.println("-----------------------------------------------------------------");
        TreeNode rootNode2 = BuildBinaryTree.buildBinaryTree2();
        System.out.println("广度优先遍历-普通" + traverseTreeLevel(rootNode2));
        System.out.println("广度优先遍历-从顶向下" + traverseTreeGroupLevelFromTop(rootNode2));
        System.out.println("广度优先遍历-从底向上" + traverseTreeGroupLevelFromBottom(rootNode2));
        System.out.println("广度优先遍历-从顶向下-锯齿状" + traverseTreeGroupLevelZigzag(rootNode2));


    }


    /**
     * 广度优先遍历给定二叉树（不区分层级）
     *
     * 解题思路：
     * 1、首先将根节点入队
     * 2、根节点出队，然后根节点的子节点入队
     * 3、依次出队，每次出队一个元素的同时，将其子节点放入队列
     *
     * 这种处理方式需要注意：因为每次当上一层元素出队之后，队列里面就是下一个队列的所有元素，
     * 但是我们并不知道何时一层元素全部出队，所以需要提前记录 size，以便知道何时结束了一层的遍历
     * 如果不需要分层则不需要记录 size，直接遍历即可
     *
     * @param rootNode
     * @return
     */
    public static String traverseTreeLevel(TreeNode rootNode){
        if (null == rootNode){
            return Collections.EMPTY_LIST.toString();
        }

        List<Integer> data = new ArrayList<>();//记录遍历结果
        LinkedList<TreeNode> linkedList = new LinkedList<>();//队列，记录树的元素

        linkedList.add(rootNode);
//        int size = 1;
        while (!linkedList.isEmpty()){
            TreeNode currNode = linkedList.remove();
            data.add(currNode.getVal());
            if (null != currNode.left){
                linkedList.add(currNode.left);
            }
            if (null != currNode.right){
                linkedList.add(currNode.right);
            }
        }
        return data.toString();
    }


    /**
     * LeetCode102 ⼆叉树的层序遍历
     * 给你⼀个⼆叉树，请你返回其按层序遍历得到的节点值。(即逐层地，从左到右访问所有节点)。
     * 和普通解法的区别就是需要区分层级，所以这里需要一个变量 size 记录一下
     *
     * 示例：
     * ⼆叉树：[3,9,20,null,null,15,7],
     *   3
     *  / \
     *  9 20
     *  / \
     * 15 7
     * 返回其层序遍历结果：
     *  [
     *  [3],
     *  [9,20],
     *  [15,7]
     *  ]
     *
     * @param rootNode
     * @return
     */
    public static String traverseTreeGroupLevelFromTop(TreeNode rootNode){
        if (null == rootNode){
            return Collections.EMPTY_LIST.toString();
        }

        List<List<Integer>> data = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        List<Integer> levelData = new ArrayList<>();
        linkedList.add(rootNode);
        int size = 1;
        while (!linkedList.isEmpty()){
            TreeNode currNode = linkedList.remove();
            if (size == 0){
                data.add(levelData);
                levelData = new ArrayList<>();
                size = linkedList.size();
                levelData.add(currNode.getVal());
            }else{
                levelData.add(currNode.getVal());
                size--;
            }
            if (null != currNode.left){
                linkedList.add(currNode.left);
            }
            if (null != currNode.right){
                linkedList.add(currNode.right);
            }
            if (linkedList.isEmpty()){//空表示后面没有数据了
                data.add(levelData);
            }
        }
        return data.toString();
    }


    /**
     * LeetCode 107 层序遍历-⾃底向上
     * 给定⼀个⼆叉树，返回其节点值⾃底向上的层序遍历。（即按从叶⼦节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * 解题思路：
     * 层级遍历的变种，只需要在存储元素的时候处理即可
     *
     * 示例：
     * ⼆叉树：[3,9,20,null,null,15,7],
     *   3
     *  / \
     *  9 20
     *  / \
     * 15 7
     * 返回其层序遍历结果：
     *  [
     *  [15,7],
     *  [20,9],
     *  [3]
     *  ]
     *
     * @param rootNode
     * @return
     */
    public static String traverseTreeGroupLevelFromBottom(TreeNode rootNode){
        if (null == rootNode){
            return null;
        }

        LinkedList<ArrayList<Integer>> data = new LinkedList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        ArrayList<Integer> levelData = new ArrayList<>();
        linkedList.add(rootNode);
        int size = 1;
        while (!linkedList.isEmpty()){
            TreeNode currNode = linkedList.remove();
            if (size == 0){
                data.addFirst(levelData);
                levelData = new ArrayList<>();
                size = linkedList.size();
                levelData.add(currNode.getVal());
            }else{
                levelData.add(currNode.getVal());
                size--;
            }
            if (null != currNode.left){
                linkedList.add(currNode.left);
            }
            if (null != currNode.right){
                linkedList.add(currNode.right);
            }
            if (linkedList.isEmpty()){
                data.addFirst(levelData);
            }
        }
        return data.toString();
    }


    /**
     * LeetCode103 ⼆叉树的锯⻮形层序遍历
     * 给定⼀个⼆叉树，返回其节点值的锯⻮形层序遍历。（即先从左往右，再从右往左进⾏下⼀层遍历，以此类推，层与层之间交替进⾏）。
     *
     * 解体思路：
     * 层级遍历的变种，只需存储元素处理分为奇偶方式处理即可
     *
     * 示例：
     * ⼆叉树：[3,9,20,null,null,15,7],
     *   3
     *  / \
     *  9 20
     *  / \
     * 15 7
     * 返回其层序遍历结果：
     *  [
     *  [3],
     *  [20,9],
     *  [15,7]
     *  ]
     *
     * @param rootNode
     * @return
     */
    public static String traverseTreeGroupLevelZigzag(TreeNode rootNode){
        if (null == rootNode){
            return null;
        }

        LinkedList<LinkedList<Integer>> data = new LinkedList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        LinkedList<Integer> levelData = new LinkedList<>();
        linkedList.add(rootNode);
        int size = 1;
        int count = 1;
        while (!linkedList.isEmpty()){
            TreeNode currNode = linkedList.remove();
            if (size == 0){
                count++;
                data.addLast(levelData);
                levelData = new LinkedList<>();
                size = linkedList.size();
                if (count % 2 == 0){
                    levelData.addFirst(currNode.getVal());
                }else{
                    levelData.addLast(currNode.getVal());
                }
            }else{
                if (count % 2 == 0){
                    levelData.addFirst(currNode.getVal());
                }else{
                    levelData.addLast(currNode.getVal());
                }
                size--;
            }
            if (null != currNode.left){
                linkedList.add(currNode.left);
            }
            if (null != currNode.right){
                linkedList.add(currNode.right);
            }
            if (linkedList.isEmpty()){
                data.addLast(levelData);
            }
        }
        return data.toString();
    }


    /**----------------------------------------------以下为复盘练习使用方法-----------------------------------------*/


    public static String testTraverseTreeLevel(TreeNode rootNode){
        if (null == rootNode){
            return "";
        }
        List<Integer> data = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        linkedList.add(rootNode);

        while (!linkedList.isEmpty()){
            TreeNode currNode = linkedList.remove();
            data.add(currNode.getVal());
            if (null != currNode.left){
                linkedList.add(currNode.left);
            }
            if (null != currNode.right){
                linkedList.add(currNode.right);
            }
        }
        return JSONObject.toJSONString(data);
    }


    public static String testTraverseTreeGroupLevelFromTop(TreeNode rootNode){
        List<List<Integer>> data = new ArrayList<>();
        if (null == rootNode){
            return JSONObject.toJSONString(data);
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();

        List<Integer> levelData = new ArrayList<>();
        linkedList.add(rootNode);
        int size = 1;
        while (!linkedList.isEmpty()){
            TreeNode treeNode = linkedList.remove();
            levelData.add(treeNode.val);
            if (null != treeNode.left){
                linkedList.add(treeNode.left);
            }
            if (null != treeNode.right){
                linkedList.add(treeNode.right);
            }
            size--;
            if (size == 0){
                size = linkedList.size();
                data.add(levelData);
                levelData = new ArrayList<>();
            }
            if(linkedList.isEmpty() && !levelData.isEmpty()){
                data.add(levelData);
            }
        }
        return JSONObject.toJSONString(data);
    }


    public static String testTraverseTreeGroupLevelZigzag(TreeNode root){
        List<List<Integer>> data = new ArrayList<>();
        if (null == root){
            return JSONObject.toJSONString(data);
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        LinkedList<Integer> levelData = new LinkedList<>();
        boolean left = true;//第一次从左边开始存元素，如果为false，则从右边
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            int val = node.val;
            if (left){
                levelData.addLast(val);
            }else {
                levelData.addFirst(val);
            }
            if (null != node.left){
                queue.add(node.left);
            }
            if (null != node.right){
                queue.add(node.right);
            }
            size--;
            if (size == 0){
                data.add(levelData);
                levelData = new LinkedList<>();
                size = queue.size();
                if (left){
                    left = false;
                } else {
                    left = true;
                }
            }
            if (queue.isEmpty() && !levelData.isEmpty()){
                data.add(levelData);
            }
        }
        return JSONObject.toJSONString(data);
    }

}
