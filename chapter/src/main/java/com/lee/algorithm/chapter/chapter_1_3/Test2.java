package com.lee.algorithm.chapter.chapter_1_3;

import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangLe
 * @date 2019/9/18 10:10
 * @description 此类中用于讨论Java中的共变数组和类型擦除
 */
public class Test2 {
    public static void main(String[] args) {
//        test1();
//        test2();
        test5();
    }

    /**
     * 讨论Java中的共变数组
     * 如果类 Base 是类 Sub 的基类，那么 Base[] 就是 Sub[] 的基类。
     * 而泛型是不可变的(invariant)，List<Base>不会是List<Sub>的基类，更不会是它的子类。
     */
    public static void test1() {
        // Object[] 是 String[] 的基类,但是下边的代码会出现运行时错误.
        Object[] o = new String[2];
        o[0] = 12;

        // 泛型是不可变的,ArrayList<Object>不是ArrayList<Integer>的基类.所以会产生编译期错误.
        // ArrayList<Object> l = new ArrayList<Integer>();

    }

    public static void test2() {
        // 创建一个List数组
//        List<Integer>[] listArr = (List<Integer>[]) new ArrayList[10];
        List<Integer>[] listArr = (List<Integer>[]) new Object[10];
        listArr[0] = new ArrayList<>();
        List<Integer>[] listArr2 = new ArrayList[10];


    }

    /**
     * 创建泛型数组
     */
    public static <T> void test4() {
        T[] t = (T[]) new Object[10];
    }

    public static void test5() {
        List<Integer>[] arrList = new ArrayList[10];
        arrList[0] = new ArrayList();
        List<Integer> integers = arrList[0];
    }
}
