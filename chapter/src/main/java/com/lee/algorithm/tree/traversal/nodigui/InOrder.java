package com.lee.algorithm.tree.traversal.nodigui;

import com.lee.algorithm.tree.traversal.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归方式实现二叉树的中序遍历
 * <p>
 * 非递归中序遍历实现思路如下所示:
 * 1.先将根节点入栈
 * 2.将当前节点的所有左孩子入栈，直到左孩子为空
 * 3.访问栈顶元素，如果栈顶元素存在右孩子，则继续第2步
 * 4.重复第2、3步，直到栈为空并且所有的节点都被访问
 *
 * @author lee
 * @date 2020/3/23 21:44
 */
public class InOrder {
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
        List<Integer> pre = in(bTree);
        pre.forEach(c -> System.out.print(c + ","));

    }

    public static List<Integer> in(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode temp = root;

        while (temp != null || !stack.empty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.lChild;
            }
            // 没有左孩子了就出栈
            temp = stack.pop();
            // 访问栈顶元素
            result.add(temp.value);
            if (temp.rChild != null) {
                temp = temp.rChild;
            } else {
                temp = null;
            }

        }

        return result;
    }
}
