package com.lee.algorithm.chapter.chapter_1_2;

import java.util.Date;

/**
 * @author WangLe
 * @date 2019/9/9 16:40
 * @description 断言测试
 */
public class AssertTest {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println("断言之前====" + s);
        // 断言需要在命令号参数里面设置:-enableassertions,当开启断言以后,当断言为后的语句为false时,会自动终止程序
        assert !s.equals("hello") : "字符串就是hello";
        System.out.println("断言之后====" + s);

    }
}
