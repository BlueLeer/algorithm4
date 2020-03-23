package com.lee.algorithm.other.test.dp3;

/**
 * 动态规划
 *
 * @author WangLe
 * @date 2019/10/12 15:46
 * @description 问题描述:给定一组数字和一个值,选择数字中的某些数,看看能不能相加得到给定的值,如果可以返回true,否则返回false
 * 例如: 1,2,3,4,5,2,4 给定值:8  3+5可以得到
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 9, 3, 6, 9};
        int[] arr2 = {1, 4, 6, 8, 9};
        System.out.println(dp_sum(arr, arr.length - 1, 55)); // false
        System.out.println(dp_sum2(arr, arr.length - 1, 55)); // false
    }

    /**
     * 使用递归
     *
     * @param arr
     * @param index
     * @param sum
     * @return
     */
    public static boolean dp_sum(int[] arr, int index, int sum) {
        // 递归出口条件
        if (sum == 0) {
            return true;
        } else if (index == 0) {
            return sum == arr[0];
        } else if (arr[index] > sum) { // 如果当前的值大于了sum值,则直接跳过
            return dp_sum(arr, index - 1, sum);
        } else {
            // 如果当前index下标的值入选
            boolean b1 = dp_sum(arr, index - 1, sum - arr[index]);
            // 如果当前index下标的值落选
            boolean b2 = dp_sum(arr, index - 1, sum);
            return b1 || b2;
        }

    }

    // 还存在问题,待解决
    public static boolean dp_sum2(int[] arr, int index, int sum) {
        // 创建一个二维数组,其中:一维存放 从0到sum值,二维存放当前index处的值是否能满足条件
        boolean[][] bb = new boolean[sum + 1][arr.length];
        // 根据递归的出口条件,初始化二维数组
        for (int i = 0; i < sum+1; i++) {
            bb[i][0] = true;
        }
        for (int i = 0; i < arr.length; i++) {
            bb[0][i] = false;
            if (i == arr[0]) {
                bb[0][i] = true;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (arr[i] > j) {
                    bb[j][i] = bb[j][i-1];
                }else {
                    // 不选
                    boolean b1 = bb[j][i-1];
                    // 选择
                    boolean b2 = bb[j-arr[i]][i-1];
                    bb[j][i] = b1||b2;
                }
            }
        }

        return bb[sum][arr.length-1];
    }
}
