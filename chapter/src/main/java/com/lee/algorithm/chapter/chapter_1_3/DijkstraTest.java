package com.lee.algorithm.chapter.chapter_1_3;

import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangLe
 * @date 2019/9/12 15:59
 * @description Dijkstra 双栈算术表达式求值算法
 * 原则:
 * 1.将操作数压入操作数栈
 * 2.将运算符压入运算符栈
 * 3.忽略左括号
 * 4.在遇到右括号的时候弹出一个操作符和两个操作数,得到运算结果后,将结果压入操作数栈
 *
 * 前提:必须不能省略括号
 */
public class DijkstraTest {
    public static void main(String[] args) {
        String exp = "((1+(2*3))*(4+(2*3)))";
        int result = ((1 + (2 * 3)) * (4 + (2 * 3)));

        // 存贮操作符的栈(+ - * /)
        Stack<Character> opts = new Stack<>();
        // 存储值的栈
        Stack<Integer> vals = new Stack<>();
        char[] chars = exp.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                // 忽略左括号
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                opts.push(c);
            } else if (c == ')') {
                Integer first = vals.pop();
                Integer second = vals.pop();
                Integer subResult = 0;
                Character opt = opts.pop();
                switch (opt) {
                    case '+':
                        subResult = second + first;
                        break;
                    case '-':
                        subResult = second - first;
                        break;
                    case '*':
                        subResult = second * first;
                        break;
                    case '/':
                        subResult = second / first;
                        break;
                }
                vals.push(subResult);
            } else {
                vals.push(Integer.parseInt(String.valueOf(c)));
            }
        }

        System.out.println(vals.peek());
        System.out.println("real result:" + result);
    }
}
