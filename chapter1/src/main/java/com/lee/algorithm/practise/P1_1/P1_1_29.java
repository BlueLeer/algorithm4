package com.lee.algorithm.practise.P1_1;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * @author WangLe
 * @date 2019/7/29 18:00
 * @description
 */
public class P1_1_29 {
    public static void main(String[] args) {
        int[] whiteList = In.readInts(args[0]);
        Arrays.sort(whiteList);

        System.out.println(Arrays.toString(whiteList));
        System.out.println(count(whiteList, 343));
    }

    /**
     * 二分查找，需要保证传入的a数组是一个有序的数组
     *
     * @param key
     * @param a
     * @return 返回key在a数组中的index(位置)
     */
    public static int search(int key, int[] a, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (a[mid] > key) {
            return search(key, a, low, mid - 1);
        }

        if (a[mid] < key) {
            return search(key, a, mid + 1, high);
        }

        return mid;
    }

    public static int rank(int[] array, int key) {
        int search = search(key, array, 0, array.length - 1);
        while (search > 0 && array[search - 1] == key) {
            search--;
        }

        return search;
    }

    public static int count(int[] array, int key) {
        int count = 0;
        int search = search(key, array, 0, array.length - 1);
        if (search != -1){
            count++;
        }
        while (search > 0 && array[search - 1] == key) {
            search--;
            count++;
        }
        while (search < array.length && array[search + 1] == key) {
            search++;
            count++;
        }

        return count;
    }
}
