package com.lee.algorithm.other.test;

/**
 * @author lee
 * @date 2020/2/16 21:23
 */
public class Demo1 {
    public static void main(String[] args) {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hello";
        b[1] = 43;
        System.out.println(a);
    }
}
