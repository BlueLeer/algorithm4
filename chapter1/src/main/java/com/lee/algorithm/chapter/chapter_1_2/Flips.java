package com.lee.algorithm.chapter.chapter_1_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author WangLe
 * @date 2019/9/3 16:24
 * @description 模拟投掷硬币
 */
public class Flips {
    public static void main(String[] args) {
        System.out.println("请输入要模拟投掷硬币的次数:");
        int T = StdIn.readInt();

        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        for (int i = 0; i < T; i++) {
            boolean bernoulli = StdRandom.bernoulli(0.5);
            if (bernoulli) {
                heads.increment();
            } else {
                tails.increment();
            }
        }

        System.out.printf("投掷硬币次数:%d,正面朝上:%d,反面朝上:%d \n", T, heads.getCount(), tails.getCount());


    }
}
