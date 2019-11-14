package com.lee.algorithm.practise.P1_2;

import com.lee.algorithm.chapter.chapter_1_2.Counter;

import java.util.Arrays;

/**
 * @author WangLe
 * @date 2019/9/10 16:14
 * @description
 */
public class P9 {

    public static void main(String[] args) {
        int[] ns = {12, 2, 3, 3, 4343, 5, 232, 543, 656, 67};
        Arrays.sort(ns);
        search(5, ns, new Counter("二分查找数目记录器"));
    }

    /**
     * 二分查找，需要保证传入的a数组是一个有序的数组
     *
     * @param key
     * @param a
     * @return 返回key在a数组中的index(位置)
     */
    public static int search(int key, int[] a, Counter counter) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            counter.increment();
            int mid = (low + high) / 2;
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                System.out.println("查找时,和键进行比对的次数为:" + counter.getCount());
                return mid;
            }
        }
        System.out.println("查找时,和键进行比对的次数为:" + counter.getCount());
        return -1;
    }
}
