package com.lee.algorithm.tree.traversal;


import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历,即:第二次到达某个节点时访问,所得的序列为中序遍历序列
 * 也可以说是:先访问左孩子,再访问根节点,最后访问右孩子
 *
 * @author lee
 * @date 2020/3/22 22:47
 */
public class MidOrder {
    TreeNode root;

    // 相当于将一个顺序存储结构的完全二叉树变成链式的存储结构
    {
        TreeNode[] nodes = new TreeNode[10];
        for (int i = 0; i < 10; i++) {
            nodes[i] = new TreeNode(i + 1);
        }
        root = nodes[0];
        for (int i = 0; i < 10; i++) {
            if (2 * i + 1 < 10) nodes[i].lChild = nodes[2 * i + 1]; // 左子树
            if (2 * i + 2 < 10) nodes[i].rChild = nodes[2 * i + 2]; // 右子树
        }
    }

    public List<Integer> tra() {
        List<Integer> result = new ArrayList<>();
        traItem(root, result);
        return result;
    }

    private void traItem(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        traItem(root.lChild, result);
        result.add(root.value);
        traItem(root.rChild, result);
    }

    public static void main(String[] args) {
        MidOrder preOrder = new MidOrder();
        List<Integer> tra = preOrder.tra();
        tra.forEach(c -> {
            System.out.println(c + ",");
        });
    }
}
