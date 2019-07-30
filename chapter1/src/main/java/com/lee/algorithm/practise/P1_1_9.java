package com.lee.algorithm.practise;

import junit.framework.Assert;

/**
 * @author WangLe
 * @date 2019/7/30 10:21
 * @description
 */
public class P1_1_9 {
    public static void main(String[] args) {
        Assert.assertEquals("相等的",toHex(100), toHex2(100));
    }

    public static String toHex(int num) {
        return Integer.toBinaryString(num);
    }

    public static String toHex2(int num) {
        String result = "";
        for (int n = num; n > 0; n /= 2) {
            result = (n % 2) + result;
        }

        return result;
    }


}
