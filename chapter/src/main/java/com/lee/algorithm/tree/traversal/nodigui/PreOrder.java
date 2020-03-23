package com.lee.algorithm.tree.traversal.nodigui;

import com.lee.algorithm.tree.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归的方式实现先序遍历
 * <p>
 * 1.先将根节点入栈
 * 2.访问根节点
 * 3.如果根节点存在右孩子，则将右孩子入栈
 * 4.如果根节点存在左孩子，则将左孩子入栈（注意：一定是右孩子先入栈，然后左孩子入栈）
 * 5.重复2-4
 *
 * @author lee
 * @date 2020/3/23 22:26
 */
public class PreOrder {
    /**
     * 构建一颗二叉树(完全二叉树)
     *
     * @return
     */
    private static TreeNode buildTree() {
        TreeNode[] treeNodes = new TreeNode[10];
        for (int i = 0; i < 10; i++) {
            TreeNode treeNode = new TreeNode(i + 1);
            treeNodes[i] = treeNode;
        }
        TreeNode root = treeNodes[0];
        // 将顺序存储的二叉树转换为链式存储
        for (int i = 0; i < 10; i++) {
            if (i * 2 + 1 < 10) treeNodes[i].lChild = treeNodes[i * 2 + 1];
            if (i * 2 + 2 < 10) treeNodes[i].rChild = treeNodes[i * 2 + 2];
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode bTree = buildTree();
        List<Integer> pre = pre(bTree);
        pre.forEach(c -> System.out.print(c + ","));

    }

    public static List<Integer> pre(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            result.add(pop.value);
            if (pop.rChild != null) {
                stack.push(pop.rChild);
            }
            if (pop.lChild != null) {
                stack.push(pop.lChild);
            }
        }

        return result;
    }
}
