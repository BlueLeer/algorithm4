package com.lee.algorithm.practise.P1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

import java.io.File;

/**
 * @author WangLe
 * @date 2019/9/19 11:29
 * @description
 */
public class P43 {
    public static void main(String[] args) {
        File file = new File("D:\\maven-repo\\com\\cpic");
        Queue<String> queue = new Queue<>();
        printFile(queue, file, 0);
        for (String s : queue) {
            System.out.println(s);
        }
    }

    public static void printFile(Queue<String> queue, File file, int time) {

        StringBuilder pre = new StringBuilder();
        for (int i = 0; i < time; i++) {
            pre.append("-");
        }

        queue.enqueue(pre.toString() + file.getName());
        if (!file.isDirectory()) {
            return;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                printFile(queue, file1, time + 1);
            }
        }
    }
}
