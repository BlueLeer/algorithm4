package com.lee.algorithm.sort;

import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

/**
 * 快速排序
 *
 * @author lee
 * @date 2020/3/1 20:40
 */

public class QuickSort {
    public static void sort(@NotNull Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(Comparable[] a, int low, int high) {
        if (low >= high) return;
        // 下标为j处的元素已经排定了
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);

    }


    /**
     * 切分位置,每调用一次,则会确定一个元素的位置
     *
     * @param a
     * @param low
     * @param high
     * @return 返回已经排定的元素的下标
     */
    private static int partition(Comparable[] a, int low, int high) {
        // 左、右扫描指针
        int i = low, j = high + 1;
        // 切分元素
        Comparable v = a[low];

        while (true) {

            while (less(a[++i], v)) if (i == high) break;
            while (less(v, a[--j])) if (j == low) break;
            if (i >= j) break; // 当i >= j表示i和j不用交换
            exchange(a, i, j); // 否则,a[i]和a[j]需要交换
        }
        exchange(a, low, j);

        return j;
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
        Integer[] array1 = {1, 2, 3, 4};
        sort(array1);
        print(array1);
        System.out.println(isSorted(array1));

//        // 测试用例2
//        Integer[] array2 = {1};
//        sort(array2);
//        print(array2);
//        System.out.println(isSorted(array2));
//
//        // 测试用例3
//        Integer[] array3 = {};
//        sort(array3);
//        print(array3);
//        System.out.println(isSorted(array3));
//
//
//        // 测试用例4
//        String[] array4 = {"Hello", "nihao", "world", "World", "a", "A", "b", "B"};
//        sort(array4);
//        print(array4);
//        System.out.println(isSorted(array4));
    }
}