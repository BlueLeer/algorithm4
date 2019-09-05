package com.lee.algorithm.practise.P1_1;

/**
 * @author WangLe
 * @date 2019/7/30 15:57
 * @description 由对数的基本公式(乘变加, 除变减, 指数变倍数) ln(N!) = ln1+ln2+...+lnN
 */
public class P1_1_20 {
    public static void main(String[] args) {
        System.out.println(ln(10));
    }

    /**
     * 计算 ln(n!) n!表示n的阶乘 ln表示自然对数
     *
     * @param n
     * @return
     */
    public static double ln(int n) {
        if (n <= 0) {
            return Double.NaN;
        } else if (n == 1) {
            return 0;
        } else {
            return Math.log(n) + ln(n - 1);
        }

    }
}
