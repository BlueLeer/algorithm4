package com.lee.algorithm.practise.P1_2;

/**
 * @author WangLe
 * @date 2019/9/10 15:53
 * @description 回环变位:如果字符串s中的字符循环移动任意的位置之后总是能够得到另一个字符串t,
 * 那么s就称作t的回环变位
 */
public class P6 {
    public static void main(String[] args) {
        String s = "hello";
        String t = "llohe2";
        System.out.printf("s和t是否回环变位? ==" + isLoopback(s, t));
    }

    public static boolean isLoopback(String s, String t) {
        String o = s + s;
        if (o.contains(t)) {
            return true;
        }
        return false;
    }
}
