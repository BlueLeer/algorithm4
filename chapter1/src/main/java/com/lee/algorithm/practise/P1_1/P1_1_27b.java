package com.lee.algorithm.practise.P1_1;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author WangLe
 * @date 2019/7/31 15:06
 * @description
 */
public class P1_1_27b {
    public static double binomial(double[][] v, int n, int k, double p, Counter c) {
        if (n == 0 && k == 0) return 1.0;
        if (n < 0 || k < 0) return 0.0;

        if (v[n][k] == -1) {
            c.increment();
            v[n][k] = (1.0 - p) * binomial(v, n - 1, k, p, c) + p * binomial(v, n - 1, k - 1, p, c);
        }

        return v[n][k];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]),
                k = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);

        double[][] v = new double[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int i1 = 0; i1 <= k; i1++) {
                v[i][i1] = -1;
            }
        }

        Counter c = new Counter("calls");

        double b = binomial(v, n, k, p, c);

        StdOut.println(b);
        StdOut.println(c);
    }
}
