package com.lee.algorithm.practise;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author WangLe
 * @date 2019/7/30 14:45
 * @description 实际上是计算斐波拉契数列的前100项
 */
public class P1_1_19 {
    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int N = 0; N < 100; N++) {
            StdOut.println(N + " " + Fib(N));
        }
        System.out.println("总共耗时" + (System.currentTimeMillis() - startTime));

    }

    /**
     * by lee
     *
     * @param l
     * @param n
     */
    private static void F2(long[] l, int n) {
        if (n == 0) {
            l[n] = 0;
        } else if (n == 1) {
            l[n] = 1;
        } else {
            l[n] = l[n - 2] + l[n - 1];
        }
    }


    public static long Fib(int N, long[] f) {
        if (f[N] == 0) {
            if (N == 0) {
                f[0] = 0;
            } else if (N == 1) {
                f[1] = 1;
            } else {
                f[N] = Fib(N - 1, f) + Fib(N - 2, f);
            }
        }

        return f[N];
    }

    public static long Fib(int N) {
        long[] f = new long[N + 1];
        return Fib(N, f);
    }
}
