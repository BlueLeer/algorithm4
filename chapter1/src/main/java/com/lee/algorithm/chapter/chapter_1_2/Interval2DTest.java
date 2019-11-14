package com.lee.algorithm.chapter.chapter_1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdIn;

/**
 * @author WangLe
 * @date 2019/9/5 16:32
 * @description
 */
public class Interval2DTest {
    public static void main(String[] args) {
        System.out.println("请输入4个点:");
        double x1 = StdIn.readDouble();
        double y1 = StdIn.readDouble();
        double x2 = StdIn.readDouble();
        double y2 = StdIn.readDouble();

        Interval1D i1 = new Interval1D(x1,y1);
        Interval1D i2 = new Interval1D(x2,y2);
        Interval2D box = new Interval2D(i1,i2);
        double area = box.area();
        System.out.println("面积为: "+area);
        box.draw();
    }
}
