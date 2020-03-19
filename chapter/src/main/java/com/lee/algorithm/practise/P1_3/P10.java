package com.lee.algorithm.practise.P1_3;

import edu.princeton.cs.algs4.Stack;

/**
 * @author WangLe
 * @date 2019/9/18 14:59
 * @description 算法表达式由中序转化为前序
 */
public class P10 {
    public static void main(String[] args) {
        String s = "((8+9)*(5-(8-7)))";
        test(s);
    }

    /**
     * 运算完以后,栈顶就是想要的结果
     *
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
                String itemExp = opt + two + one + "";
                valueStack.push(itemExp);
            } else if (item == '(') {

            } else {
                valueStack.push(String.valueOf(item));
            }
        }

        System.out.println(valueStack.peek());
    }

}
