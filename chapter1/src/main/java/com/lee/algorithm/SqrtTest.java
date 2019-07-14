package com.lee.algorithm;

/**
 * Created with : IntelliJ IDEA
 * User : KingIsHappy
 * Date : 2019/7/15
 * Time : 0:11
 * Description :
 */
public class SqrtTest {

    public static void main(String[] args) {

        double t = 3.2454;
        double sqrt = sqrt(t);
        int sqrt2 = sqrtInt(160000);
        System.out.println(sqrt);
        System.out.println(sqrt2);
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
            long sq = mid * mid;
            if (sq == x) {
                System.out.println("循环次数:" + count);
                return (int) mid;
            } else if (sq < x) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }

            count++;

        }

        System.out.println("循环次数:" + count);

        return (int) j;
    }
}
