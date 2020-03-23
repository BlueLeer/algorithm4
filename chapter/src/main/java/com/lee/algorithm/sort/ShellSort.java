package com.lee.algorithm.sort;

import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

/**
 * 希尔排序，希尔排序是插入排序的进化版本
 * 通过SortCompare比较可以知道: 希尔排序比插入排序和选择排序要快得多,并且数组越大,这种优势就越大
 *
 * @author lee
 * @date 2020/2/19 9:56
 */
public class ShellSort {
    /**
     * 将数组 array 升序排列
     *
     * @param array 待排序的数组
     */
    public static void sort(@NotNull Comparable[] array) {
        int N = array.length;
        int h = 1;
        while (h < N / 3) {
            h = h * 3 + 1; // 1,4,13,40...
        }

        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < N; i++) {
                // 将a[i]插入到a[i-h]、a[i-2*h]、a[i-3*h]...之中,这就是插入排序
                // j >= h是为了保证array[j-h]数组下标不越界
                for (int j = i; j >= h && less(array[j], array[j - h]); j -= h) {
                    exchange(array, j, j - h);
                }
            }

            h = h / 3;
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
