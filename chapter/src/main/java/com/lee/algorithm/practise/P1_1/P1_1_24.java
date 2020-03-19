package com.lee.algorithm.practise.P1_1;

/**
 * @author WangLe
 * @date 2019/7/31 10:34
 * @description 欧几里得求最大公约数  a 和 b 的最大公约数也是  a 和 a mod b 的最大公约数
 */
public class P1_1_24 {
    public static void main(String[] args) {
        System.out.println(rounding(1000, 20));
    }


    public static int rounding(int a, int b) {
        // 当b为0时,表示上一次刚好能完全整除,能完全整除,代表被除数是除数的倍数,除数是这两个数的最大公约数
        if (b == 0) {
            return a;
        } else {
            return rounding(b, a % b);
        }
    }


}
