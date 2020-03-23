package com.lee.algorithm.sort;

/**
 * 归并排序 (自顶向上的归并排序)
 *
 * @author lee
 * @date 2020/3/1 10:52
 */

import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

public class MergeSort {

    /**
     * 归并所需的辅助数组
     */
    private static Comparable[] aux;

    public static void sort(Comparable[] array) {
        aux = new Comparable[array.length]; // 一次性分配空间
        sort(array, 0, array.length - 1);

    }

    /**
     * 将数组 array 升序排列
     * sort()方法的作用在于:安排多次merge()方法调用的正确顺序(本数组要想排序,必须先要让子数组先归并排序)
     *
     * @param array 待排序的数组
     */
    private static void sort(@NotNull Comparable[] array, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        // 将左半边排序
        sort(array, low, mid);
        // 将右半边排序
        sort(array, mid + 1, high);

        merge(array, low, mid, high);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        // 先将所有的元素复制到辅助数组aux中,然后再归并会原来的数组a中去
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) { // 左半边用尽,取右半边的元素王a数组中填充
                a[k] = aux[j++];
            } else if (j > hi) { // 右半边用尽
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) { // 右半边的当前元素小于左半边的当前元素,就取右半边的元素
                a[k] = aux[j++];
            } else { // 右半边的当前元素大于等于左半边的当前元素,就取左半边的元素
                a[k] = aux[i++];
            }
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
        Integer[] array1 = {3, 2, 4};
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
