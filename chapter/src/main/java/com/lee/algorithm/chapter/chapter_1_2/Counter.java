package com.lee.algorithm.chapter.chapter_1_2;

/**
 * @author WangLe
 * @date 2019/9/3 16:26
 * @description
 */
public class Counter {
    /**
     * 该计数器的ID
     */
    private String id;

    private Integer count;

    public void increment() {
        this.count++;

    }

    public Counter(String id) {
        this.id = id;
        this.count = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                ", count=" + count +
                '}';
    }
}
