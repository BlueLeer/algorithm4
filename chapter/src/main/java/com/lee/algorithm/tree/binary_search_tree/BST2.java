package com.lee.algorithm.tree.binary_search_tree;

import com.lee.algorithm.tree.traversal.TreeNode;

import java.util.Stack;
import java.util.stream.Stream;

/**
 * 二叉搜索树
 *
 * @author lee
 * @date 2020/3/24 14:22
 */
public class BST2 {
    public static TreeNode insert(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (node == null) {
            return root;
        }

        if (node.value == root.value) {
            System.out.println("插入失败");
            return root;
        } else if (node.value > root.value) {
            root.rChild = insert(root.rChild, node);
        } else {
            root.lChild = insert(root.lChild, node);
        }

        return root;
    }


    private static TreeNode tree;
    public static void main(String[] args) {
        TreeNode[] treeNodes = new TreeNode[10];
        Stream.of(5, 3, 4, 6, 8, 9, 2, 7, 1).forEach(integer -> {
            TreeNode treeNode = new TreeNode(integer);
            tree = insert(tree, treeNode);
        });

        in(tree);


    }

    /**
     * 中序遍历下
     */
    private static void in(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.empty()) {
            // 左孩子都先入栈
            while (temp != null) {
                stack.push(temp);
                temp = temp.lChild;
            }
            TreeNode pop = stack.pop();
            System.out.println(pop.value + ",");
            if (pop.rChild != null) {
                temp = pop.rChild;
            } else {
                temp = null;
            }
        }
    }


}
