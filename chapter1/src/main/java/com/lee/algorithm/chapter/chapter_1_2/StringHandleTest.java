package com.lee.algorithm.chapter.chapter_1_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.Vector;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author WangLe
 * @date 2019/9/9 10:45
 * @description
 */
public class StringHandleTest {
    public static void main(String[] args) throws IOException {
//        String s = "hellolleh";
//        System.out.println(isPalindrome(s));
//
//        String rawArr = "jfasod ljfie dfkjdi jf jdfi";
//        String[] strings = buildStringArray(rawArr);
//        for (String string : strings) {
//            System.out.println(string);
//        }

//        String sss = "abcdefhy";
//        System.out.printf("判断字符串当中所有的字母是否按照字母表顺序排列: %b\n", isSorted(s));
//        System.out.printf("判断字符串当中所有的字母是否按照字母表顺序排列: %b", isSorted(sss));

//        StdInTest();

//        testFile();

//        testGetFileFromResource();
        testInteger();
    }

    /**
     * 判断是否回文串
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int N = s.length();
        for (int i = 0; i < N / 2; i++) {
            if (s.charAt(i) != s.charAt(N - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 从控制台输入中解析出字符串数组
     *
     * @param s
     * @return
     */
    public static String[] buildStringArray(String s) {
        String regular = "\\s";
        String[] split = s.split(regular);
        return split;
    }

    public static boolean isSorted(String s) {
        int N = s.length();
        // 去掉字符串中的空格
        s = s.replace(" ", "");
        for (int i = 0; i < N - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public static void StdInTest() {
        In in = new In("http://news-at.zhihu.com/api/4/news/latest");
        String s = in.readAll();
        Out out = new Out("D:\\lee_java\\algorithm4\\chapter1\\src\\main\\java\\com\\lee\\algorithm\\chapter\\chapter_1_2\\a.txt");
        out.print(s);
    }

    public static void testFile() throws IOException {
        // 文件相对地址,创建的文件将会以当前项目的根目录为相对目录的起始目录
        String fileName = "Hello.txt";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static void testGetFileFromResource() throws IOException {
        try (
                FileOutputStream out = new FileOutputStream("a_out.txt")
        ) {
            URL url = StringHandleTest.class.getResource("/a.txt");
            URLConnection site = url.openConnection();
            InputStream is = site.getInputStream();
            byte temp[] = new byte[1024];

            int flag = 0;
            while ((flag = is.read(temp)) > 0) {
                out.write(temp, 0, flag);
            }
        }
    }

    /**
     * Integer 的包装类型 如果是 -128到127范围之内的,都会先在内存中先创建对象,然后谁需要就
     * 将该对象指向给谁,不会重新的创建对象
     * 例:
     * a = 127; b = 127;
     * a == b? true
     * a = -128; b = -128;
     * a == b? true
     * a = 1000; b = 1000
     * a ==b? false
     */
    public static void testInteger(){
        Integer a = 128;
        Integer b = 128;
        System.out.printf("a=b? --> %b \n",a==b);

        Integer c = 127;
        Integer d = 127;
        System.out.printf("c=d? --> %b \n",c==d);

        Integer e = -128;
        Integer f = -128;
        System.out.printf("e=f? --> %b",e==f);

        String s1 = "hello";
        String s2 = "nihao";

    }
}
