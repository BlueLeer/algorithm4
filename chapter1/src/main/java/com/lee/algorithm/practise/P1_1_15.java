package com.lee.algorithm.practise;

/**
 * @author WangLe
 * @date 2019/7/30 11:18
 * @description
 */
public class P1_1_15 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1};
        int[] histogram = histogram(a, 3);
        for (int i = 0; i < histogram.length; i++) {
            System.out.print(histogram[i]);
        }
    }

    public static int[] histogram(int[] a, int M) {
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            int statistics = statistics(a, i);
            result[i] = statistics;
        }

        return result;
    }

    public static int statistics(int[] nums, int key) {
        int count = 0;
        for (int num : nums) {
            if (num == key) {
                count++;
            }
        }

        return count;
    }
}
