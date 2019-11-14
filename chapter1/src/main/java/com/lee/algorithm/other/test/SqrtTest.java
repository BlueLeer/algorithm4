package com.lee.algorithm.other.test;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created with : IntelliJ IDEA
 * User : KingIsHappy
 * Date : 2019/7/15
 * Time : 0:11
 * Description :
 */
public class SqrtTest {

    public static void main(String[] args) {

    }

    /**
     * 计算平方根(牛顿迭代法)
     *
     * @param c
     * @return
     */
    public static double sqrt(double c) {
        if (c < 0) {
            return Double.NaN;
        }

        double err = 1e-15;
        double t = c;
        while (Math.abs(t - c / t) > err * t) {
            t = (c / t + t) / 2.0;
        }

        return t;
    }

    /**
     * 二分搜索法计算平方根
     *
     * @param x
     * @return
     */
    public static int sqrtInt(int x) {
        int count = 0;
        long i = 0;
        long j = x / 2 + 1;
        while (i <= j) {
            long mid = (i + j) / 2;
            long product = mid * mid;
            if (product == x) {
                System.out.println("循环次数:" + count);
                return (int) mid;
            } else if (product < x) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }

            count++;

        }

        System.out.println("循环次数:" + count);

        boolean a = false;
        boolean b = true;
        System.out.println();
        char c1 = 'A';
        char c2 = 'b';
        System.out.println(c1 > c2);
        return (int) j;
    }

    @Test
    public void test22(){
        BigDecimal bigDecimal = new BigDecimal(1.00000);
        BigDecimal bigDecimal2 = new BigDecimal(1.000);
        boolean equals = bigDecimal.equals(bigDecimal2);
        System.out.println(equals);

    }
}
