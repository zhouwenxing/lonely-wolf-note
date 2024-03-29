package com.lonely.wolf.note.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 深度优先
 *
 * 对称和反转专题
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/1/16
 * @since jdk1.8
 */
public class $6_TraverseTreeByDFS3 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);


    }


    /**
     * LeetCode100
     * 给你两棵⼆叉树的根节点 p 和 q ，编写⼀个函数来检验这两棵树是否相同。如果两个树在结构上相同，
     * 并且节点具有相同的值，则认为它们是相同的
     *
     * 示例1：
     * 输⼊：p = [1,2,3], q = [1,2,3] 输出：true
     *
     * 示例2：
     * 输⼊：p = [1,2], q = [1,null,2] 输出：false
     *
     * @param rootNode1
     * @param rootNode2
     * @return
     */
    public static boolean isSameTree(TreeNode rootNode1,TreeNode rootNode2){
        if (null == rootNode1 && null == rootNode2){
            return true;
        }
        if (null == rootNode1 || null == rootNode2){
            return false;
        }
        if (rootNode1.val != rootNode2.val){
            return false;
        }
        return isSameTree(rootNode1.left,rootNode2.left) && isSameTree(rootNode1.right,rootNode2.right);
    }


    /**
     * 合并两棵树
     * 给定两个⼆叉树，想象当你将它们中的⼀个覆盖到另⼀个上时，两个⼆叉树的⼀些节点便会重叠。你需要将他们合
     * 并为⼀个新的⼆叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新⼆叉树的节点
     *
     *示例 1:
     * 输⼊:
     *  Tree 1   Tree 2
     *     1       2
     *    / \     / \
     *   3   2   1   3
     *  /         \   \
     * 5           4   7
     * 输出:
     * 合并后的树:
     *      3
     *     / \
     *    4   5
     *   / \   \
     *  5  4    7
     * 咕泡出
     *
     * @param rootNode1
     * @param rootNode2
     * @return
     */
    public static TreeNode mergeTwoTree(TreeNode rootNode1,TreeNode rootNode2){
        if (null == rootNode1){
            return rootNode2;
        }
        if (null == rootNode2){
            return rootNode1;
        }

        TreeNode mergedNode = new TreeNode(rootNode1.val + rootNode2.val);
        mergedNode.left = mergeTwoTree(rootNode1.left,rootNode2.left);
        mergedNode.right = mergeTwoTree(rootNode1.right,rootNode2.right);
        return mergedNode;
    }


    /**
     * 对称⼆叉树
     * LeetCode 101 给定⼀个⼆叉树，检查它是否是镜像对称的。例如下⾯这个就是对称⼆叉树
     * 解题思路：递归法
     *       1
     *     /  \
     *    2    2
     *   / \  / \
     *  3  4 4  3
     *
     * 解题思路：
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root){
        if (null == root){
            return true;
        }
        if (null == root.left && null == root.right){
            return true;
        }
        if (null == root.left || null == root.right){
            return false;
        }
        return root.left.val == root.right.val && checkSymmetric(root.left.left,root.right.right) && checkSymmetric(root.left.right,root.right.left);
    }

    private static boolean checkSymmetric(TreeNode node1,TreeNode node2){
        if (null == node1 && null == node2){
            return true;
        }
        if (null == node1 || null == node2){
            return false;
        }
        return node1.val == node2.val && checkSymmetric(node1.left,node2.right) && checkSymmetric(node1.right,node2.left);
    }


    /**
     * LeetCode226(剑指 offer 27 题) 翻转⼆叉树，将⼆叉树整体反转
     *
     * 解题思路：只需要交换左右节点，不过要注意，采用前后序遍历方式才行，中序遍历会有问题。
     *
     * 中序遍历先交换左节点的子节点，这时候会将左右交换，继续遍历右节点，而这时候右节点是原先的左节点，
     * 所以左节点会重复反转（等于没反转），而右节点却没有反转
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root){
        if (null == root){
            return root;
        }
        //后序遍历
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        //前序遍历
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//        invertTree(root.left);
//        invertTree(root.right);

        return root;
    }


    /**----------------------------------------------以下为复盘练习使用方法-----------------------------------------*/

    /**
     * 利用迭代法判断是否对称二叉树
     * @param root
     * @return
     */
    public static boolean testIsSymmetricByTraversal(TreeNode root){
        if (null == root){
            return true;
        }
        if (null == root.left && null == root.right){
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        LinkedList<TreeNode> tempQueue = new LinkedList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.removeLast();
            if (null != node){
                TreeNode left = node.left;
                TreeNode right = node.right;
                queue.addFirst(left);
                queue.addFirst(right);
            }
            tempQueue.addFirst(node);
            size--;
            if (size == 0){
                size = queue.size();
                boolean result = check(tempQueue,root);
                if (!result){
                    return false;
                }
                tempQueue.clear();
            }
        }
        return true;
    }


    /**
     * 采用迭代法
     * @param root
     * @return
     */
    public static TreeNode testInvertTreeByTraversal(TreeNode root){
        if (null == root){
            return root;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int size = 1;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.removeLast();

            swap(node);//交换左右节点

            if (null != node.left){
                queue.add(node.left);
            }
            if (null != node.right){
                queue.add(node.right);
            }
            size--;
            if (size == 0){
                size = queue.size();
            }
        }
        return root;
    }


    public static boolean testIsSameTree(TreeNode p, TreeNode q){
        if (null == p && null == q){
            return true;
        }
        if (null == p || null == q){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return testIsSameTree(p.left,q.left) && testIsSameTree(p.right,q.right);
    }

    private static void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    private static boolean check(LinkedList<TreeNode> queue,TreeNode root) {
        if (queue.isEmpty()){
            return true;
        }
        if (queue.size() == 1){
            if (queue.getFirst() == root){
                return true;
            }else{
                return false;
            }
        }
        TreeNode left = queue.removeFirst();
        TreeNode right = queue.removeLast();
        if (null == left && null == right){
            return check(queue,root);
        }
        if (null == left || null == right){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
       return check(queue,root);
    }

    /**
     * 合并 2 颗二叉树
     * @param root1
     * @param root2
     * @return
     */
    public static TreeNode testMergeTwoTree(TreeNode root1,TreeNode root2){
        if(null == root1 && null == root2){
            return null;
        }
        if (null == root1){
            return root2;
        }
        if (null == root2){
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = testMergeTwoTree(root1.left,root2.left);
        root.right = testMergeTwoTree(root1.right,root2.right);
        return root;
    }
}
