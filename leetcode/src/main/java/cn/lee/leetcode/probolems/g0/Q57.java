package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Title: Q57
 * @Description: https://leetcode-cn.com/problems/insert-interval/
 * @author: libo
 * @date: 2020/11/4 8:46
 * @Version: 1.0
 */
@Slf4j
public class Q57 {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[][]{new int[]{1, 5}, new int[]{6, 9}}, new Q57().insert(new int[][]{new int[]{1, 3}, new int[]{6, 9}}, new int[]{2, 5}));
        Assert.assertArrayEquals(new int[][]{new int[]{1, 5}, new int[]{6, 9}}, new Q57().insert(new int[][]{new int[]{1, 3}, new int[]{6, 9}}, new int[]{2, 5}));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        return null;
    }

    public int[][] inser2(int[][] intervals, int[] newInterval) {
        int m1 = intervals.length > 0 ? intervals[intervals.length - 1][1] : 0;
        int m2 = newInterval.length > 0 ? newInterval[1] : 0;
        int max = Math.max(m1, m2);
        int[] ss = new int[max + 1];
        for (int[] arr : intervals) {
            for (int i = arr[0]; i < arr[1]; i++) {
                ss[i] = 1;
            }
        }
        for (int i = newInterval[0]; i < newInterval[1]; i++) {
            ss[i] = 1;
        }
        int left = 0, right = 0;
        int[][] res = new int[max][2];
        int index = 0;
        for (int i = 1; i <= max; i++) {
            if (ss[i - 1] == 0 && ss[i] == 1) {
                left = i;
            }
            if (ss[i - 1] == 1 && ss[i] == 0) {
                right = i;
                res[index] = new int[]{left, right};
                index++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}
