package com.lee.algorithm.tree.traversal;


import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层次遍历:也就是从上往下,从左往右的访问方式.
 *
 * @author lee
 * @date 2020/3/22 22:47
 */
public class LevelOrder {
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

    /**
     * 层次遍历1
     */
    public List<List<Integer>> level() {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            // 当前层的元素
            List<Integer> levelData = new ArrayList<>();
            while (count > 0) {
                TreeNode poll = queue.poll();
                levelData.add(poll.value);
                if (poll.lChild != null) queue.add(poll.lChild);
                if (poll.rChild != null) queue.add(poll.rChild);
                count--;
            }
            result.add(levelData);
        }

        return result;
    }

    /**
     * 层次遍历2,和上面的方式是一样的
     * @return
     */
    public List<Integer> levelOrder2() {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            result.add(poll.value);
            if (poll.lChild != null) queue.add(poll.lChild);
            if (poll.rChild != null) queue.add(poll.rChild);
        }

        return result;
    }

    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        List<List<Integer>> level = levelOrder.level();
        level.forEach(l -> {
            StringBuilder sb = new StringBuilder();
            l.forEach(i -> sb.append(i + ","));
            System.out.println(sb.toString());
        });

        System.out.println("====================================");
        List<Integer> integerList = levelOrder.levelOrder2();
        integerList.forEach(c -> System.out.print(c + ","));

    }
}
