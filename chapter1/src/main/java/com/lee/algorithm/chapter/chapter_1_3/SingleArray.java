package com.lee.algorithm.chapter.chapter_1_3;

/**
 * @author WangLe
 * @date 2019/9/16 15:13
 * @description 单向链表
 */
public class SingleArray {

    private static class Node<Item> {
        Item item;
        Node next;
    }

    public static void main(String[] args) {
        Node<String> first = new Node<>();
        Node<String> second = new Node<>();
        Node<String> third = new Node<>();
        first.item = "hello";
        second.item = "java";
        third.item = "!";
        first.next = second;
        second.next = third;


    }
}
