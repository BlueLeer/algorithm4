package com.lee.algorithm.practise.P1_3;

import edu.princeton.cs.algs4.Stack;

/**
 * @author WangLe
 * @date 2019/9/18 13:31
 * @description 判定括号是否匹配完整
 */
public class P4 {
    public static void main(String[] args) {
        String s = "[](})()[]{}[{]}";
        String s2 = "([](){}{}[](){[()]})";
        System.out.println(isMatch(s2));

    }

    private static boolean isMatch(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (aChar == '}' || aChar == ']' || aChar == ')') {
                Character pop = stack.pop();
                char temp = ' ';
                switch (aChar) {
                    case '}':
                        temp = '{';
                        break;
                    case ']':
                        temp = '[';
                        break;
                    case ')':
                        temp = '(';
                        break;
                }

                if (!pop.equals(temp)){
                    return false;
                }
            } else {
                stack.push(aChar);
            }
        }
        return true;

    }
}
