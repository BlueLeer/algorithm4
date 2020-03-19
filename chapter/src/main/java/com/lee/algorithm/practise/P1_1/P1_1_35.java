package com.lee.algorithm.practise.P1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * @author WangLe
 * @date 2019/8/30 16:02
 * @description 模拟掷骰子
 */
public class P1_1_35 {
    private static final int SIDES = 6;

    public static void main(String[] args) {
        probability();
    }

    private static void probability() {
        double prob[] = new double[SIDES * 2 + 1];
        int result[] = new int[SIDES * 2 + 1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++) {
                result[i + j] += 1; // 结果命中一次,count加1
            }
        }

        for (int i = 0; i < result.length; i++) {
            prob[i] = result[i] / 36.0;
            System.out.printf("摇筛子数字 %d 出现的概率为: %f \n", i, prob[i]);
        }

        int[] num = new int[2 * SIDES + 1];
        // 你的经验数字(就是说你觉得掷这么多次,就能达到经验数据和准确数字的吻合程度达到小数点后三位)
        int N = StdIn.readInt();

        for (int i = 0; i < N; i++) {
            // StdRandom.discrete(prob) 表示从prob
            num[StdRandom.discrete(result)]++;
        }
        double frequency;
        boolean isAccurate = true;
        System.out.print("Frequency:");
        for (int i = 2; i <= 2 * SIDES; i++) {
            frequency = (double) num[i] / N;
            System.out.printf("%6.3f", frequency);
            if (Math.abs(frequency - prob[i]) > 0.001) {
                isAccurate = false;
            }
        }
        System.out.println();
        System.out.println("Is accurate? " + isAccurate);
    }


}
