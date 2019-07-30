package com.lee.algorithm.practise;

/**
 * @author WangLe
 * @date 2019/7/30 11:40
 * @description
 */
public class P1_1_16 {
    public static String exR1(int n) {
        if (n <= 0) {
            return "";
        }
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    public static void main(String[] args) {
//        System.out.println(exR1(6));
        System.out.println(exR2(6));
    }

    public static String exR2(int n) {
        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        if (n <= 0) {
            return "";
        }
        return s;
    }
}
