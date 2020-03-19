package com.lee.algorithm.other.test;

/**
 * @author WangLe
 * @date 2019/8/1 11:09
 * @description
 */
public class Shift {
    public static void main(String[] args) {
        System.out.println(shift(16));
//        System.out.println(shift(15));
    }

    public static int shift(int a) {
        int b = a;
        // |= 表示按位或后赋值
        b |= b >>> 1;
        b |= b >>> 2;
        b |= b >>> 4;
        b |= b >>> 8;
        b |= b >>> 16;

        return b + 1;
    }
}
