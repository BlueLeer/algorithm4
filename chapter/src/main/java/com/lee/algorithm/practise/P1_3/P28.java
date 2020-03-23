package com.lee.algorithm.practise.P1_3;

/**
 * @author WangLe
 * @date 2019/9/18 15:46
 * @description
 */
public class P28 {
    public static void main(String[] args) {
        Node<Integer> first = new Node<>();
        first.item = 12;
        Node<Integer> seconde = new Node<>();
        seconde.item = 10;
        Node<Integer> third = new Node<>();
        third.item = 20;
        Node<Integer> fourth = new Node<>();
        fourth.item = 100;
        Node<Integer> fifth = new Node<>();
        fifth.item = 5;
        first.next = seconde;
        seconde.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // 环形链表, 注释掉,不然栈溢出了
        // fifth.next = first;

        System.out.println(max(first, 0));
    }

    private static Integer max(Node<Integer> first, int max) {
        if (first == null) {
            return max;
        }

        if (first.item > max) {
            max = first.item;
        }

        return max(first.next, max);
    }

    private static class Node<Item> {
        Item item;
        Node next;
    }
}
