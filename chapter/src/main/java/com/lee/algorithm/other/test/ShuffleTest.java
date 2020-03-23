package com.lee.algorithm.other.test;

import edu.princeton.cs.algs4.*;

/**
 * @author WangLe
 * @date 2019/7/26 16:38
 * @description
 */
public class ShuffleTest {
    /**
     * 将array中的数进行随机打乱
     *
     * @param array
     * @return
     */
    public static void shuffle(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            // 随机获取大于i的数组下标
            int uniform = StdRandom.uniform(n - i) + i;
            int temp = array[i];
            array[i] = array[uniform];
            array[uniform] = temp;
        }

    }

    public static void main(String[] args) {
        int[] arrays = {1, 3, 5, 6, 2, 4, 32, 4, 5, 343, 3, 23, 23, 2, 232, 5, 66, 22};
        System.out.println("before:" + arrays.length);
        shuffle(arrays);
        System.out.println("end:" + arrays.length);
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }

    }
}
