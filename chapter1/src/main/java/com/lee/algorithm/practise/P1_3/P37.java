package com.lee.algorithm.practise.P1_3;

import edu.princeton.cs.algs4.Queue;

/**
 * @author WangLe
 * @date 2019/9/18 16:36
 * @description Josephus问题
 */
public class P37 {
    public static void main(String[] args) {
        int num = 10;
        int deadNum = 100;
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < num; i++) {
            queue.enqueue(i);
        }

        while (queue.size() > 0) {
            // 循环报数,报过数的就放到队列尾部
            for (int i = 0; i < deadNum; i++) {
                queue.enqueue(queue.dequeue());
            }
            // 此时,处于队列头部的就是接下来报出 deadNum 的人,将其打印出来
            System.out.print(queue.dequeue());
        }
    }
}
