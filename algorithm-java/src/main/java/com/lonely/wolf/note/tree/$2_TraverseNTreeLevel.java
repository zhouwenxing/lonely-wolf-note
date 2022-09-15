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


    public static String traverseTreeLevel(NTreeNode rootNode){
        if (null == rootNode){
            return Collections.EMPTY_LIST.toString();
        }
        List<List<Integer>> data = new ArrayList<>();
        List<Integer> levelData = new ArrayList<>();
        LinkedList<NTreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
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



}
