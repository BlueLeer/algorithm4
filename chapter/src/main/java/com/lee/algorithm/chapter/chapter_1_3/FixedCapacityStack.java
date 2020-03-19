package com.lee.algorithm.chapter.chapter_1_3;

import java.util.Arrays;

/**
 * @author WangLe
 * @date 2019/9/16 10:17
 * @description
 */
public class FixedCapacityStack<Item> {
    private Item[] items;

    // 长度
    private Integer N;

    public FixedCapacityStack(Integer size) {
        this.items = (Item[]) new Object[size];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == items.length;
    }

    public Item pop() {
        if (isEmpty()) {
            return null;
        }
        Item item = items[--N];
        items[N] = null;
        if (N > 0 && N == items.length / 4) {
            resize(items.length / 2);
        }

        return item;
    }

    public void push(Item item) {
        if (isFull()) {
            resize(items.length * 2);
        }
        items[N++] = item;
    }

    public Item peek() {
        if (isEmpty()) {
            return null;
        }
        return items[N - 1];
    }

    private void resize(int newCapacity) {
        System.out.println("容量调整...");
        Item[] temps = (Item[]) new Object[newCapacity];
        for (int i = 0; i < items.length && i< temps.length; i++) {
            temps[i] = items[i];
        }
        items = temps;

    }

    @Override
    public String toString() {
        return "FixedCapacityStack{" +
                "items=" + Arrays.toString(items) +
                ", N=" + N +
                '}';
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> stringStack = new FixedCapacityStack<>(10);
        for (int i = 0; i < 1000; i++) {
            stringStack.push("Hello+" + i);
        }

        for (int i = 0; i < 1000; i++) {
            stringStack.pop();
        }

        System.out.println(stringStack.toString());

    }
}
