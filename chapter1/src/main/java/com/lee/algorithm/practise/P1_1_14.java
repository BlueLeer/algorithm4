package com.lee.algorithm.practise;

/**
 * @author WangLe
 * @date 2019/7/30 11:10
 * @description
 */
public class P1_1_14 {
    public static void main(String[] args) {
        System.out.println(lg(1));
    }

    public static int lg(int num) {
        int result = 0;
        while (num / 2 > 0) {
            result++;
            num = num / 2;
        }

        return result;
    }
}
