package com.lonely.wolf.note.tree;

import java.util.List;

/**
 * N 叉树节点
 * @author lonely_wolf
 * @version 1.0
 * @date 2022/1/9
 * @since jdk1.8
 */
public class NTreeNode {
    public int val;
    public List<NTreeNode> children;

    public NTreeNode() {}

    public NTreeNode(int _val) {
        val = _val;
    }

    public NTreeNode(int _val, List<NTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
