package com.lee.algorithm.sort;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 比较各个算法排序所花费的时间
 *
 * @author lee
 * @date 2020/2/19 10:42
 */
public class SortCompare {
    /**
     * 计算排序所要花的时间
     *
     * @param algName
     * @param a
     * @return
     */
    public static double time(String algName, Double[] a) {
        Stopwatch stopwatch = new Stopwatch();
        switch (algName) {
            case "Insertion":
                InsertionSort.sort(a);
                break;
            case "Selection":
                SelectionSort.sort(a);
                break;
            case "Shell":
                ShellSort.sort(a);
                break;
            default:
                break;
        }

        return stopwatch.elapsedTime();

    }

    /**
     * 对T个长度为N的数组进行排序
     *
     * @param algName
     * @param N
     * @param T
     * @return 所花费的总时间
     */
    public static double timeRandomInput(String algName, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            // 进行一次测试(生成一个数组并排序)
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }

            total += time(algName, a);

        }

        return total;
    }

    public static void main(String[] args) {
        double insertion = timeRandomInput("Insertion", 1000, 100);
        double selection = timeRandomInput("Selection", 1000, 100);
        double shell = timeRandomInput("Shell", 1000, 100);

        System.out.println("Insertion 排序所花费的时间为: " + insertion);
        System.out.println("Selection 排序所花费的时间为: " + selection);
        System.out.println("Shell 排序所花费的时间为: " + shell);
    }
}
