package com.lee.algorithm.chapter.chapter_1_3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

import java.util.Iterator;

/**
 * @author WangLe
 * @date 2019/9/11 14:32
 * @description Bag Queue Stack 三种常见的数据结构
 */
public class Test {
    public static void main(String[] args) {
        // Bag
        System.out.println("包[Bag]============================");
        Bag<Integer> bag = new Bag<>();
        bag.add(123);
        bag.add(33);
        bag.add(3443);
        Iterator<Integer> iterator = bag.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
        for (int i = 0; i < bag.size(); i++) {

        }

        // 队列 FIFO 先进先出
        System.out.println("队列[Queue]============================");
        Queue<String> queue = new Queue<>();
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");
        queue.enqueue("fourth");
        queue.dequeue(); // 删除最近正在排队的元素(当前元素队列的第一个)
        queue.enqueue("fifth");
        Iterator<String> iterator1 = queue.iterator();
        while (iterator1.hasNext()) {
            String next = iterator1.next();
            System.out.println(next);
        }

        // 栈 LIFO 后进先出
        System.out.println("栈[Stack]============================");
        Stack<String> stack = new Stack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        stack.push("fourth");
        stack.push("fifth");
        String peek = stack.peek(); // peek()方法,意为偷窥,返回当前栈的顶部,但是不移除
        System.out.println("peek:" + peek);
        String pop = stack.pop();
        System.out.println("pop:" + pop);
        Iterator<String> iterator2 = stack.iterator();
        while (iterator2.hasNext()) {
            String next = iterator2.next();
            System.out.println(next);
        }

        System.out.println("test====================================");
        test();
    }

    public static void test() {
        String[] a = {"343", "343", "545", "454", "nihao", "hahhaha", "zenmela", "apple"};
        int count = 0;
        for (String s : a) {
            count++;
            if (s.equals("nihoa")) {
                return;
            }
        }

        System.out.println("count:" + count);
    }
}
