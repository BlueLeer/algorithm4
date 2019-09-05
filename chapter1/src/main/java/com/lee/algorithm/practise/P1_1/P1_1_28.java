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
public class P1_1_28 {
    public static void main(String[] args) {
        int[] whiteList = In.readInts(args[0]);
        Arrays.sort(whiteList);

        // 删除排序后的所有的重复元素
        int[] result = new int[whiteList.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        for (int i = 0; i < whiteList.length; i++) {
            int a = whiteList[i];
            int search = search(a, whiteList, 0, whiteList.length - 1);
            if (search != -1) {
                result[search] = a;
            }
        }
        System.out.println(Arrays.toString(result));
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
}
