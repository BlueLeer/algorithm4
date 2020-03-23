package com.lee.algorithm.sort;

import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

/**
 * 选择排序
 * <p>
 * 选择排序: 首先，找到数组中那个最小的元素，其次，将它和数组的第一个元素交换位置（如果第一个元素就是最小元素，就自己和自己交换位置）
 * 。再次，在剩下的元素中找到最小的元素，将它和数组中的第二个元素交换位置。如此往复，直到最后一个元素。这种方法就叫做选择排序，
 * 因为它不断的选择剩余元素中的最小者。
 *
 * @author lee
 * @date 2020/2/12 22:19
 */
public class SelectionSort {
    public static void sort(@NotNull Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (less(array[j], array[minIndex])) {
                    minIndex = j;

                }
            }
            exchange(array, i, minIndex);
        }
    }

    /**
     * 验证 a<b
     *
     * @param a
     * @param b
     * @return
     */
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     * 交换 下标 i和j 处的值,下标从0开始
     *
     * @param array
     * @param i
     * @param j
     */
    private static void exchange(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void print(Comparable[] array) {
        for (Comparable comparable : array) {
            StdOut.print(comparable + " ");
        }
        StdOut.println();
    }

    /**
     * 判断数组是否已经排好序(由小到大)
     *
     * @param array
     */
    private static boolean isSorted(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (less(array[i + 1], array[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // 测试用例1
        Integer[] array1 = {1, 2, 3, 4, 23, 0, 5, 3};
        sort(array1);
        print(array1);
        System.out.println(isSorted(array1));

        // 测试用例2
        Integer[] array2 = {1};
        sort(array2);
        print(array2);
        System.out.println(isSorted(array2));

        // 测试用例3
        Integer[] array3 = {};
        sort(array3);
        print(array3);
        System.out.println(isSorted(array3));


        // 测试用例4
        String[] array4 = {"Hello", "nihao", "world", "World", "a", "A", "b", "B"};
        sort(array4);
        print(array4);
        System.out.println(isSorted(array4));
    }
}
