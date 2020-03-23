package com.lee.algorithm.chapter.chapter_2_1;

import org.jetbrains.annotations.NotNull;

/**
 * @author lee
 * @date 2020/2/12 11:09
 */
public class ComparableDate implements Comparable<ComparableDate> {
    private final int year;
    private final int month;
    private final int day;

    public ComparableDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }


//    @Override
//    public int compareTo(@NotNull ComparableDate that) {
//        if (this.year > that.year) {
//            return 1;
//        } else if (this.year < that.year) {
//            return -1;
//        } else {
//            if (this.month > that.month) {
//                return 1;
//            } else if (this.month < that.month) {
//                return -1;
//            } else {
//                if (this.day > that.day) {
//                    return 1;
//                } else if (this.day < that.day) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            }
//        }
//    }

    /**
     * 比上面的compareTo方法简洁不少,而且更易读,今后实现compareTo方法首选这种方式
     *
     * @param that
     * @return
     */
    @Override
    public int compareTo(@NotNull ComparableDate that) {
        if (this.year > that.year) return 1;
        if (this.year < that.year) return -1;
        if (this.month > that.month) return 1;
        if (this.month < that.month) return -1;
        if (this.day > that.day) return 1;
        if (this.day < that.day) return -1;
        return 0;
    }

    public static void main(String[] args) {
        ComparableDate date1 = new ComparableDate(2019, 10, 11);
        ComparableDate date2 = new ComparableDate(2019, 10, 11);

        System.out.println(date1.compareTo(null));
    }

}
