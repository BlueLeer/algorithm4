package com.lee.algorithm.practise.P1_3;

import edu.princeton.cs.algs4.Stack;

/**
 * @author WangLe
 * @date 2019/9/18 13:45
 * @description 实际上是存放10进制的整数转化成二进制整数以后的所有的二进制位(栈顶为二进制的高位)
 */
public class P5 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int N = 50;
        while (N > 0) {
            int n = N % 2;
            stack.push(n);
            N /= 2;
        }

        for (Integer integer : stack) {
            System.out.print(integer);
        }
    }
}
