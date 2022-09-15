package com.lonely.wolf.note.tree;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DFS（Deep First Search）深度优先搜索
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/1/16
 * @since jdk1.8
 */
public class $4_TraverseTreeByDFS {
    public static void main(String[] args) {
        TreeNode rootNode = BuildBinaryTree.buildBinaryTree();
        List<Integer> list = afterorderTraversal(rootNode);
        System.out.println("深度优先遍历" + JSONObject.toJSONString(list));

        System.out.println(null == null);
    }


    /**
     * 后序遍历
     * @param root
     * @return
     */
    public static List<Integer> afterorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        afterOrder(root, res);
        return res;
    }


    private static void afterOrder(TreeNode root, List<Integer> res) {
        if(null == root){
            return;
        }
        afterOrder(root.left,res);
        afterOrder(root.right,res);
        res.add(root.val);
    }


}
