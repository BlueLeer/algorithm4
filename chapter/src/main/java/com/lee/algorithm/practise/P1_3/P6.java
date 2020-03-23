package com.lee.algorithm.practise.P1_3;

import com.lee.algorithm.chapter.chapter_1_3.Queue;

import java.util.Stack;

/**
 * @author WangLe
 * @date 2019/9/18 14:09
 * @description
 */
public class P6 {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        Stack<Integer> stack = new Stack<>();
        stack.push(q.dequeue());
        stack.push(q.dequeue());
        stack.push(q.dequeue());
        stack.push(q.dequeue());

        System.out.println(q.size());
        System.out.println(stack);
    }
}
