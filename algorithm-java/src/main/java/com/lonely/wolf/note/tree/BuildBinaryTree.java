package com.lonely.wolf.note.tree;

import com.lonely.wolf.note.tree.TreeNode;

/**
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/1/5
 * @since jdk1.8
 */
public class BuildBinaryTree {
    public static void main(String[] args) {

    }

    public static TreeNode buildBinaryTree() {
        TreeNode rootNode = new TreeNode(3);
        rootNode.left = new TreeNode(9);
        rootNode.right = new TreeNode(20);
        rootNode.right.left = new TreeNode(15);
        rootNode.right.right = new TreeNode(7);
        return rootNode;
    }

    public static TreeNode buildBinaryTree2() {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.left.left = new TreeNode(8);
        node.left.right = new TreeNode(13);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        return node;

    }
}
