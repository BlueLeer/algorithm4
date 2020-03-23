package com.lee.algorithm.other.test.dp;

/**
 * @author WangLe
 * @date 2019/10/11 16:25
 * @description 动态规划问题1
 */
public class DPMaxSalary {
    public static void main(String[] args) {
        J j1 = new J(1, 4, 5);
        J j2 = new J(3, 5, 1);
        J j3 = new J(0, 6, 8);
        J j4 = new J(4, 7, 4);
        J j5 = new J(3, 8, 6);
        J j6 = new J(5, 9, 3);
        J j7 = new J(6, 10, 2);
        J j8 = new J(8, 11, 4);
        J[] js = new J[]{j1, j2, j3, j4, j5, j6, j7, j8};
        int opt = opt(6, js);
        System.out.println(opt);
    }

    static class J {
        int s;
        int e;
        int pay;
        public J(int s, int end, int payment) {
            this.s = s;
            this.e = end;
            this.pay = payment;
        }
    }
    public static int opt(int i, J[] js) {
        if (i == 0) {
            return 0;
        }
        int do_s = opt(prev(i, js), js) + js[i - 1].pay;
        int undo_s = opt(i - 1, js);

        return do_s > undo_s ? do_s : undo_s;
    }
    public static int prev(int i, J[] js) {
        for (int i1 = i - 2; i1 >= 0; i1--) {
            J j = js[i1];
            if (j.e <= js[i - 1].s) {
                return i1 + 1;
            }
        }
        return 0;
    }
}
