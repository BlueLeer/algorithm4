package com.lee.algorithm.other.test.dp2;

/** 动态规划
 * @author WangLe
 * @date 2019/10/12 15:28
 * @description 问题描述:给出一组数字,算出不相邻的数字和的最大值
 * 例如: 1,4,6,8,9 那么不相邻的数字之和的最大值为:1+6+9
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 9, 3, 6, 9};
        int[] arr2 = {1, 4, 6, 8, 9};
        // 使用递归时的方法
        System.out.println(dp_sum(arr, arr.length - 1));
        System.out.println(dp_sum(arr2, arr2.length - 1));

        // 不使用递归时的方法
        System.out.println(dp_sum2(arr));
        System.out.println(dp_sum2(arr2));
    }

    /**
     * 使用递归
     *
     * @param arr
     * @param index
     * @return
     */
    public static int dp_sum(int[] arr, int index) {
        if (index == 0) {
            return arr[0];
        } else if (index == 1) {
            return arr[1];
        } else {
            // 选择index处的数字时
            int a = arr[index] + dp_sum(arr, index - 2);
            // 不选择index处的数字时
            int b = dp_sum(arr, index - 1);
            return Math.max(a, b);
        }
    }

    /**
     * 不使用递归
     *
     * @param arr
     * @return
     */
    public static int dp_sum2(int[] arr) {
        int[] maxSum = new int[arr.length];
        maxSum[0] = arr[0];
        maxSum[1] = arr[1];
        for (int i = 2; i < arr.length; i++) {
            // 选择下标为i处的数字时的情况
            int A = arr[i] + maxSum[i-2];
            // 不选择下标为i处的数字时的情况
            int B = maxSum[i-1];
            maxSum[i] = Math.max(A,B);
        }

        return maxSum[arr.length-1];
    }
}
