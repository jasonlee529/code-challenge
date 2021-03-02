package cn.lee.leetcode.probolems.g3;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class Q338 {
    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[]{0, 1, 1}, countBits(2));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, countBits(5));
    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int t = i;
            int cnt = 0;
            while (t > 0) {
                int n = t % 2;
                if (n == 1) {
                    cnt++;
                }
                t = t / 2;
            }
            res[i] = cnt;
        }
        return res;
    }

    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int t = i;
            int cnt = 0;
            while (t > 0) {
                int n = t % 2;
                if (n == 1) {
                    cnt++;
                }
                t = t / 2;
            }
            res[i] = cnt;
        }
        return res;
    }
}
