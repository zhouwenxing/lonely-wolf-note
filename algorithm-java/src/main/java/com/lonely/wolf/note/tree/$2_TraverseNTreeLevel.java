package com.lonely.wolf.note.tree;

import java.util.*;

/**
 * leetcode 429. N 叉树的层序遍历
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历），
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/1/9
 * @since jdk1.8
 */
public class $2_TraverseNTreeLevel {
    public static void main(String[] args) {


    }


    /**
     * LeetCode 429 N叉树的层次遍历
     * @param root
     * @return
     */
    public static String traverseTreeLevel(NTreeNode root){
        if (null == root){
            return Collections.EMPTY_LIST.toString();
        }
        List<List<Integer>> data = new ArrayList<>();
        List<Integer> levelData = new ArrayList<>();
        LinkedList<NTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = queue.size();
        while (!queue.isEmpty()){
            if (size == 0){
                size = queue.size();
                data.add(levelData);
                levelData = new ArrayList<>();
            }
            NTreeNode currNode = queue.removeFirst();
            levelData.add(currNode.val);

            List<NTreeNode> childNodes = currNode.children;
            if (null != childNodes && childNodes.size() > 0){
                for (NTreeNode node : childNodes){
                    queue.addLast(node);
                }
            }
            size--;
        }
        if (levelData.size() > 0){//处理最后一层数据
            data.add(levelData);
        }
        return data.toString();
    }

    /**----------------------------------------------以下为复盘练习使用方法-----------------------------------------*/

    public static List<List<Integer>> testTraverseTreeLevel(NTreeNode root){
        List<List<Integer>> data = new ArrayList<>();
        if (null == root){
            return data;
        }
        LinkedList<NTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = queue.size();
        List<Integer> levelData = new ArrayList<>();
        while (!queue.isEmpty()){
            NTreeNode node = queue.removeFirst();
            levelData.add(node.val);
            List<NTreeNode> childNodes = node.children;
            if (!childNodes.isEmpty()){
                for (NTreeNode childNode : childNodes){
                    queue.addLast(childNode);
                }
            }
            size--;
            if (size == 0){
                data.add(levelData);
                levelData = new ArrayList<>();
                size = queue.size();
            }
        }
        return data;
    }
}
