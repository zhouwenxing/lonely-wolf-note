package com.lonely.wolf.note.tree;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

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
        List<Integer> list = afterOrderRecursion(rootNode);
        System.out.println("递归法后续遍历：" + JSONObject.toJSONString(list));

        List<Integer> list2 = preOrderTraversal(rootNode);
        System.out.println("迭代法前序遍历结果：" + JSONObject.toJSONString(list2));

        List<Integer> list3 = midOrderTraversal(rootNode);
        System.out.println("迭代法中序遍历结果：" + JSONObject.toJSONString(list3));

        List<Integer> list4 = afterOrderTraversal(rootNode);
        System.out.println("迭代法后序遍历结果：" + JSONObject.toJSONString(list4));
    }


    /**
     * 递归法：后序遍历
     * @param root
     * @return
     */
    public static List<Integer> afterOrderRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        afterOrder(root, res);
        return res;
    }


    private static void afterOrder(TreeNode root, List<Integer> res) {
        if(null == root){
            return;
        }
        //前中后序遍历只需修改后面3行代码顺序即可
        afterOrder(root.left,res);
        afterOrder(root.right,res);
        res.add(root.val);
    }


    /**
     * 迭代法：前序遍历
     * @param root
     * @return
     */
    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || null != node){
            while (null != node){
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }


    /**
     * 迭代法：中序遍历
     * @param root
     * @return
     */
    public static List<Integer> midOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || null != node){
            while (null != node){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }


    /**
     * 迭代法：后序遍历
     * @param root
     * @return
     */
    public static List<Integer> afterOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root){
            return res;
        }
        Stack<TreeNode> stack1 = new Stack<>();//过程存储
        Stack<TreeNode> stack2 = new Stack<>();//结果存储
        stack1.push(root);
        while (!stack1.isEmpty()){
           TreeNode node = stack1.pop();
           stack2.push(node);//中右左存入
           if (null != node.left){
               stack1.push(node.left);
           }
           if (null != node.right){
               stack1.push(node.right);
           }
        }
        while (!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
        return res;
    }

}
