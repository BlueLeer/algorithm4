package com.lee.algorithm.other.test;

/**
 * @author WangLe
 * @date 2019/10/11 15:40
 * @description 斐波拉契数列
 */
public class FibTest {
    public static void main(String[] args) {
        // 打印出斐波拉契数列的前100个数
        for (int i = 0; i < 100; i++) {
            int fib = fib(i);
            System.out.print(fib+"  ");
        }
    }

    /**
     *
     * @param index 斐波拉契数列中的第几个数 从0开始
     * @return
     */
    public static int fib(int index) {
        if (index == 0 || index == 1) {
            return 1;
        }
        return fib(index-1)+fib(index-2);
    }
}
