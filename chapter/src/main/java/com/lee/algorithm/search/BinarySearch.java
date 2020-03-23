package com.lee.algorithm.search;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.util.Arrays;

/**
 * @author WangLe
 * @date 2019/7/29 18:00
 * @description
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] whiteList = In.readInts(args[0]);
        Arrays.sort(whiteList);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (search(key, whiteList) < 0) {
                StdOut.println(key);
            }
        }
    }

    /**
     * 二分查找，需要保证传入的a数组是一个有序的数组
     *
     * @param key
     * @param a
     * @return 返回key在a数组中的index(位置)
     */
    public static int search(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
