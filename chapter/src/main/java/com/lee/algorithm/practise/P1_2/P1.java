package com.lee.algorithm.practise.P1_2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author WangLe
 * @date 2019/9/9 17:57
 * @description
 */
public class P1 {
    public static void main(String[] args) {
        int N = StdIn.readInt();
        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            Point2D point2D = new Point2D(x,y);
            point2D.draw();
        }
    }
}
