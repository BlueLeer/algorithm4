package com.lee.algorithm.practise.P1_3;

import java.util.Arrays;

/**
 * @author WangLe
 * @date 2019/9/19 10:17
 * @description 用数组实现
 */
public class P38<Item> {
    private Item[] items;
    private int size;
    private static final int CAPACITY = 10;

    public P38() {
        items = (Item[]) new Object[CAPACITY];
        this.size = 0;
    }

    /**
     * 队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 向队列中插入一个元素
     *
     * @param item
     */
    public void insert(Item item) {
        if (this.size >= CAPACITY) {
            throw new RuntimeException("队列最大长度为10!");
        }
        this.items[size++] = item;
    }

    /**
     * 删除并返回最早插入的第K个元素,k从0开始
     *
     * @param k
     * @return
     */
    public Item delete(int k) {
        if (k >= CAPACITY) {
            throw new RuntimeException("不存在该元素!");
        }

        Item item = this.items[k];
        for (int i = k; i < this.size - 1; i++) {
            this.items[i] = this.items[i + 1];
        }
        this.items[this.size - 1] = null;

        return item;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    public static void main(String[] args) {
        P38<Integer> p38 = new P38<>();
        for (int i = 0; i < 10; i++) {
            p38.insert(i);
        }
        System.out.println("初始状态: " + p38.toString());

        p38.delete(8);
        System.out.println("8: " + p38.toString());
        p38.delete(5);
        System.out.println("5: " + p38.toString());
    }
}
