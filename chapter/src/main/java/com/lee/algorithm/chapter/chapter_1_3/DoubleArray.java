package com.lee.algorithm.chapter.chapter_1_3;

import java.util.LinkedList;

/**
 * @author WangLe
 * @date 2019/9/16 15:23
 * @description 双向链表
 */
public class DoubleArray {
    private static class Node<Item> {
        Item item;
        Node next;
        Node before;

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    '}';
        }
    }

    public static void main(String[] args) {
        // 创建一个只含有三个节点的双向链表
        Node<Integer> first = new Node<>();
        Node<Integer> second = new Node<>();
        Node<Integer> third = new Node<>();
        first.next = second;
        second.next = third;
        second.before = first;
        third.before = second;

        // 在second的前面添加一个元素
        Node<Integer> newNode = new Node<>();
        first.next = newNode;
        newNode.next = second;
        newNode.before = first;
        second.before = newNode;

        // 迭代链表
        for (Node node = first; node != null; node = node.next) {
            System.out.println(node);
        }

    }
}
