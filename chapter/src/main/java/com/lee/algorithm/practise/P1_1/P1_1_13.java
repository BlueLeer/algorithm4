package com.lee.algorithm.practise.P1_1;

/**
 * @author WangLe
 * @date 2019/7/30 10:53
 * @description
 */
public class P1_1_13 {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        transpose(nums);
    }

    public static void transpose(int[][] nums) {
        for (int j = 0; j < nums[0].length; j++) {
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i][j] + " ");
            }

            System.out.println();
        }
    }
}
