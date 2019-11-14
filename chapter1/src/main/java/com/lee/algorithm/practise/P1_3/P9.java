package com.lee.algorithm.practise.P1_3;

import edu.princeton.cs.algs4.Stack;

/**
 * @author WangLe
 * @date 2019/9/18 14:12
 * @description 编写一段程序, 从标准输入流中获取一个缺少左括号的表达式并打印出补全括号以后的表达式
 * 使用双栈法
 */
public class P9 {
    public static void main(String[] args) {
        String s = "1+2)*3-4)*5-6)))";

        test(s);

    }

    /**
     * 运算完以后,栈顶就是想要的结果
     * @param s
     */
    private static void test(String s) {
        Stack<String> optStack = new Stack<>();
        Stack<String> valueStack = new Stack<>();

        char[] items = s.toCharArray();
        for (char item : items) {
            if (item == '+' || item == '-' || item == '*' || item == '/') {
                optStack.push(String.valueOf(item));
            } else if (item == ')') {
                String one = valueStack.pop();
                String two = valueStack.pop();
                String opt = optStack.pop();
                String itemExp = "(" + two + opt + one + ")";
                valueStack.push(itemExp);
            } else {
                valueStack.push(String.valueOf(item));
            }
        }

    }
}
