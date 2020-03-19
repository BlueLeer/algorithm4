package com.lee.algorithm.practise.P1_3;

/**
 * @author WangLe
 * @date 2019/9/19 10:35
 * @description 用链表实现
 */
public class P38_2<Item> {
    // 队列开头
    private Node first;
    private Node last;
    // 队列的排队大小
    private int N;

    public P38_2() {

    }

    private class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;

        }
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.first == null;
    }

    /**
     * 向队列中插入一个元素
     *
     * @param item
     */
    public void insert(Item item) {
        Node node = new Node(item);
        node.next = null;
        if (this.first == null) {
            this.first = node;
            this.last = node;
        } else {
            this.last.next = node;
            this.last = node;
        }
        this.N++;
    }

    /**
     * 删除并返回最早插入的第K个元素,k从0开始
     *
     * @param k
     * @return
     */
    public Item delete(int k) {
        Item item = null;
        Node current = this.first;
        Node before = null;
        for (int i = 0; i < this.N; i++) {
            if (this.N == 0) {
                this.N = 0;
                break;
            } else if (k == 0) {
                item = first.item;
                this.N = 0;
                break;
            } else if (i == k) {
                before.next = current.next;
                item = current.item;
                this.N--;
                break;
            } else {
                before = current;
                current = current.next;
            }

        }
        return item;
    }

    public static void main(String[] args) {
        P38_2<Integer> p38_2 = new P38_2<>();
        p38_2.insert(0);
        p38_2.insert(1);
        p38_2.insert(2);
        p38_2.insert(3);
        p38_2.insert(4);
        p38_2.insert(5);

        p38_2.delete(4);
        p38_2.delete(4);
    }
}
