package com.lee.algorithm.practise.P1_2;

/**
 * @author WangLe
 * @date 2019/9/10 16:02
 * @description
 */
public class P7 {
    public static void main(String[] args) {
        String s = "abcdefgh";
        System.out.println(mystery(s));
    }

    /**
     * 将给定的字符串倒序输出
     * @param s
     * @return
     */
    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) {
            return s;
        }
        String a = s.substring(0,N/2);
        String b = s.substring(N/2,N);
        return mystery(b) + mystery(a);
    }
}
