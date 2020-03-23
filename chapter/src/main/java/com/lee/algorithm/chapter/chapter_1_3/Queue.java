package com.lee.algorithm.chapter.chapter_1_3;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * @author WangLe
 * @date 2019/9/17 13:53
 * @description
 */
public class Queue<Item> implements Iterable{
    private Node first;
    private Node last;
    private int N;

    /**
     * 如果需要支持迭代,就需要实现实现Iterable接口
     * @return
     */
    @NotNull
    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    /**
     * 入队
     *
     * @param item
     */
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    /**
     * 出队
     */
    public Item dequeue() {
        if (isEmpty()) {
            return null;
        }
        Node oldFirst = first;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return oldFirst.item;
    }


    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");
        queue.enqueue("fourth");

        System.out.println("入队之后=====");
        System.out.println("size: " + queue.size());
        System.out.println("first: " + queue.first.item);
        System.out.println("last: " + queue.last.item);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
//        queue.dequeue();
        System.out.println("出队之后=====");
        System.out.println("size: " + queue.size());
        System.out.println("next: " + queue.dequeue());
        System.out.println("next: " + queue.dequeue());
        System.out.println("next: " + queue.dequeue());
    }


}
