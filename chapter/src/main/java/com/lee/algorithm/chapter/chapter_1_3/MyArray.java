package com.lee.algorithm.chapter.chapter_1_3;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * @author WangLe
 * @date 2019/9/11 15:37
 * @description
 */
public class MyArray implements Iterable {

    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        for (Object o : myArray) {
            System.out.println(o);
        }
    }

    @NotNull
    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private static class MyIterator implements Iterator {
        private int length;

        @Override
        public boolean hasNext() {
            if (length > 100) {
                return false;
            }
            return true;
        }

        @Override
        public Object next() {
            length++;
            return "我是元素" + length;
        }
    }
}
