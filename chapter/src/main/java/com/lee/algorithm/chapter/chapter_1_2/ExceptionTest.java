package com.lee.algorithm.chapter.chapter_1_2;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author WangLe
 * @date 2019/9/9 16:25
 * @description
 */
public class ExceptionTest {
    public void test(String name) throws TestException{
        if (null != name && name.equals("lee")){
            throw new TestException("对不起,你不被允许访问!");
        }
    }

    public static void main(String[] args) {
        ExceptionTest test = new ExceptionTest();
        try {
            test.test("lee");
        } catch (TestException e) {
            e.printStackTrace();
            System.out.println(e.getMsg());
        }


    }
}

class TestException extends RuntimeException{
    private String msg;

    public TestException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
