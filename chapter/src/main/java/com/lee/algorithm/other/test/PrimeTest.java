package com.lee.algorithm.other.test;

public class PrimeTest {
    /**
     * 判断一个正整数是不是素数(质数)
     *
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                System.out.println("它的因数为 : " + i);
                return false;
            }
            System.out.println(i);
        }
        return true;
    }

    public static void main(String[] args) {
        boolean prime = isPrime(111);
        System.out.println("最终结果: " + prime);
    }
}
