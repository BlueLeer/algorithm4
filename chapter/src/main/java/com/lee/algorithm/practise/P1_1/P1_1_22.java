package com.lee.algorithm.practise.P1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author WangLe
 * @date 2019/7/29 18:00
 * @description
 */
public class P1_1_22 {
    public static void main(String[] args) {
        int[] whiteList = In.readInts(args[0]);
        Arrays.sort(whiteList);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (search(key, whiteList, 0, whiteList.length - 1, 0) < 0) {
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
    public static int search(int key, int[] a, int lo, int hi, int deep) {
        String format = "%" + (deep + String.valueOf(lo).length()) + "s,%s \n";
        System.out.printf(format, lo, hi);
        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;
        if (a[mid] > key) {
            deep++;
            return search(key, a, lo, mid - 1, deep);
        } else if (a[mid] < key) {
            deep++;
            return search(key, a, mid + 1, hi, deep);
        }

        return mid;


    }
}
