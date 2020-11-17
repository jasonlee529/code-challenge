package cn.lee.leetcode.probolems.g10;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Title: Q1030
 * @Description: https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 * @author: libo
 * @date: 2020/11/17 9:21
 * @Version: 1.0
 */
@Slf4j
public class Q1030 {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[][]{{0, 0}, {0, 1}}, allCellsDistOrder(1, 2, 0, 0));
    }

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int index = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[index] = new int[]{i, j};
                index++;
            }
        }
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int t1 = Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0);
                int t2 = Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0);
                return t1 - t2;
            }
        });
        return res;
    }
}
