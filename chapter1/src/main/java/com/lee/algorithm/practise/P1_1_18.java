package com.lee.algorithm.practise;

/**
 * @author WangLe
 * @date 2019/7/30 14:22
 * @description
 */
public class P1_1_18 {
    public static void main(String[] args) {
        System.out.println(mystery(2, 25));
        System.out.println((int) Math.pow(2, 25));
    }

    public static int mystery(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            return mystery(a * a, b / 2);
        }
        return mystery(a * a, b / 2) * a;
    }
}
