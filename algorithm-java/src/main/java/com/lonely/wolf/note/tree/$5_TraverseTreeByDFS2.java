package com.lonely.wolf.note.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 深度优先
 *
 * 深度和⾼度专项练习
 *
 * LeetCode104 ⼆叉树的最⼤深度
 * LeetCode110 判断平衡⼆叉树
 * LeetCode111 ⼆叉树的最⼩深度
 *
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/1/16
 * @since jdk1.8
 */
public class $5_TraverseTreeByDFS2 {
    public static void main(String[] args) {

    }


    /**
     * LeetCode104 ⼆叉树的最⼤深度
     *
     * 给定⼀个⼆叉树，找出其最⼤深度。⼆叉树的深度为根节点到最远叶⼦节点的最⻓路径上的节点数。
     * 说明: 叶⼦节点是指没有⼦节点的节点
     *
     * @param root
     * @return
     */
    public static int maxDepthByRecursion(TreeNode root){
        if (null == root){
            return 0;
        }
        int leftLength = maxDepthByRecursion(root.left);
        int rightLength = maxDepthByRecursion(root.right);

        return Math.max(leftLength,rightLength) + 1;
    }

    /**
     * 利用迭代法，也就是广度优先遍历，通过变量记录层级
     * @param root
     * @return
     */
    public static int maxDepthByIteration(TreeNode root){
        if (null == root){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);

        int depth = 0;
        int size = 1;
        while (!queue.isEmpty()){
            TreeNode curr = queue.removeLast();
            TreeNode left = curr.left;
            TreeNode right = curr.right;
            if (null != left){
                queue.addFirst(left);
            }
            if (null != right){
                queue.addFirst(right);
            }
            size--;
            if (size == 0){
                depth++;
                size = queue.size();
            }
        }
        return depth;
    }


    /**
     * LeetCode559 N叉树的最⼤深度
     *
     *
     * @param root
     * @return
     */
    public static int maxDepthForNTree(NTreeNode root){
        if (null == root){
            return 0;
        }
        if (root.children.isEmpty()){
            return 1;
        }

        List<Integer> data = new ArrayList<>();
        for (NTreeNode node : root.children){
            data.add(maxDepthForNTree(node));
        }
        return Collections.max(data) + 1;
    }


    /**
     * LeetCode110 判断平衡⼆叉树
     *
     * 给定⼀个⼆叉树，判断它是否是⾼度平衡的⼆叉树。
     * 本题中，⼀棵⾼度平衡⼆叉树定义为：⼀个⼆叉树每个节点 的左右两个⼦树的⾼度差的绝对值不超过 1
     *
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root){
        if (null == root){
            return true;
        }
        return currDepth(root) != -1;
    }

    private static int currDepth(TreeNode root){
        if (null == root){
            return 0;
        }
        int leftLength = currDepth(root.left);
        if (leftLength == -1){
            return -1;
        }
        int rightLength = currDepth(root.right);
        if (rightLength == -1){
            return -1;
        }
        if (Math.abs(leftLength - rightLength) > 1){
            return -1;
        }
        return Math.max(leftLength,rightLength) + 1;
    }


    /**
     * LeetCode111 ⼆叉树的最⼩深度
     * 给定⼀个⼆叉树，找出其最⼩深度。
     * 最⼩深度是从根节点到最近叶⼦节点的最短路径上的节点数量。
     *
     * 说明：叶⼦节点是指没有⼦节点的节点。比如下面例子中，最小深度应该是 2，也就是节点 4 所在位置
     *
     *     1
     *      \
     *       2
     *      /  \
     *     4    3
     *         / \
     *        6   5
     *
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root){
        if (null == root){
            return 0;
        }
        if (null == root.left && null == root.right){
            return 1;
        }

        int leftLength = -1;
        int rightLength = -1;
        if (null != root.left){
            leftLength = minDepth(root.left);
        }
        if (null != root.right){
            rightLength = minDepth(root.right);
        }
        if (-1 == leftLength){
            return rightLength + 1;
        }else if (-1 == rightLength){
            return leftLength + 1;
        }
        return Math.min(leftLength,rightLength) + 1;
    }


    public static int minDepth2(TreeNode root){
        if (null == root){
            return 0;
        }
        if (null == root.left && null == root.right){
            return 1;
        }

       int minDepth = Integer.MAX_VALUE;
        if (null != root.left){
            minDepth = Math.min(minDepth(root.left),minDepth);
        }
        if (null != root.right){
            minDepth = Math.min(minDepth(root.right),minDepth);
        }
        return minDepth + 1;
    }


    /**----------------------------------------------以下为复盘练习使用方法-----------------------------------------*/

    public static int testMaxDepthByRecursion(TreeNode root){
        if (null == root){
            return 0;
        }
        int leftLength = testMaxDepthByRecursion(root.left);
        int rightLength = testMaxDepthByRecursion(root.right);

        return Math.max(leftLength,rightLength) + 1;
    }




    public static boolean testIsBalanced(TreeNode root){
        if (null == root){
            return true;
        }
        int len = countDepth(root);
        return len != -1;
    }

    private static int countDepth(TreeNode node) {
        if (null == node){
            return 0;
        }
        int left = countDepth(node.left);
        if (left == -1){
            return -1;
        }
        int right = countDepth(node.right);
        if (right == -1){
            return -1;
        }
        if (Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left,right) + 1;
    }


}
