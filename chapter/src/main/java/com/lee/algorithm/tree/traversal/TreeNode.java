package com.lee.algorithm.tree.traversal;

/**
 * 二叉树节点的存储结构
 *
 * @author lee
 * @date 2020/3/22 22:45
 */
public class TreeNode {
    public int value;
    public TreeNode lChild;
    public TreeNode rChild;

    public TreeNode(int value, TreeNode lChild, TreeNode rChild) {
        this.value = value;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode() {
    }
}
