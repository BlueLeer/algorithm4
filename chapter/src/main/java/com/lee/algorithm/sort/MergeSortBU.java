package com.lee.algorithm.sort;

import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

/**
 * 归并排序 自底向上的
 *
 * @author lee
 * @date 2020/3/1 17:40
 */
public class MergeSortBU {

    /**
     * 归并所需的辅助数组
     */
    private static Comparable[] aux;

    public static void sort(Comparable[] array) {
        aux = new Comparable[array.length]; // 一次性分配空间

        int N = array.length;
        for (int sz = 1; sz < N; sz = sz + sz) { // 自低向上,先两两归并,再四四归并,再八八归并...
            for (int lo = 0; lo < N - sz; lo += sz * 2) {//lo:子数组的索引
                // 之所以high要在(lo + sz + sz - 1, N - 1)之中取最小值,是因为最后一次归并时第二个个子数组可能比第一小,为了防止(lo+sz+sz-1)越界,例如有17个元素,如果不过规定的话,租后一次归并时,就会出现越界的情况
                merge(array, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
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
