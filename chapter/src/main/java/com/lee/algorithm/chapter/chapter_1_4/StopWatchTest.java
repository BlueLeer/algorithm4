package com.lee.algorithm.chapter.chapter_1_4;

import edu.princeton.cs.algs4.DoublingTest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @author WangLe
 * @date 2019/9/19 17:06
 * @description
 */
public class StopWatchTest {
    public static void main(String[] args) {
        int N = 100000;
        double sum1 = 0.0;
        double sum2 = 0.0;

        Stopwatch stopwatch1 = new Stopwatch();
        for (int i = 1; i <= N; i++) {
            sum1 += Math.sqrt(i);
        }
        System.out.println(stopwatch1.elapsedTime());

        Stopwatch stopwatch2 = new Stopwatch();
        for (int i = 1; i <= N; i++) {
            sum2 += Math.pow(i, 0.5);
        }
        System.out.println(stopwatch2.elapsedTime());

    }
}
