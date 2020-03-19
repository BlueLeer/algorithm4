package com.lee.algorithm.practise.P1_1;

import java.util.Arrays;

/**
 * @author WangLe
 * @date 2019/7/31 16:45
 * @description
 */
public class P1_1_30 {
    public static void main(String[] args) {
        int n = 10;
        boolean[][] b = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isPrime(i, j)) {
                    b[i][j] = true;
                } else {
                    b[i][j] = false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(b[i]));
        }
    }

    public static boolean isPrime(int a, int b) {
        if (b == 0) {
            return a == 1;
        }

        return isPrime(b, a % b);
    }

}
