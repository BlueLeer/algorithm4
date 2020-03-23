package com.lee.algorithm.practise.P1_1;

import edu.princeton.cs.algs4.StdIn;

/**
 * @author WangLe
 * @date 2019/7/30 10:17
 * @description
 */
public class P1_1_3 {
    public static void main(String[] args) {
        int a = StdIn.readInt();
        int b = StdIn.readInt();
        int c = StdIn.readInt();
        if (a==b && b==c){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }
    }
}
