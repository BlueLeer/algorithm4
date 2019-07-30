package com.lee.algorithm.other.test;

import org.junit.Test;

/**
 * @author WangLe
 * @date 2019/7/15 19:40
 * @description 堆排序
 */
public class HeapSortTest {
    /**
     * 堆排序
     *
     * @param array
     * @return
     * TODO 未完成创建堆
     */
    @Test
    public int[] sort(int[] array) {
        Node tree = new Node();
        tree.value = array[0];
        Node pointer = tree;
        int index = 1;

        int floor = 1;
        while (index < array.length) {
            if (pointer.left == null) {
                pointer.left = new Node(array[index], null, null);
            } else if (pointer.right == null) {
                pointer.left = new Node(array[index], null, null);
            } else {
                pointer = pointer.left;
            }
        }

        return null;
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node() {
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
