package cn.lee.leetcode.probolems.g20;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q2022
 * @Description: https://leetcode-cn.com/problems/convert-1d-array-into-2d-array/
 * @author: libo
 * @date: 2022/1/1 0001 22:38
 * @Version: 1.0
 */
@Slf4j
public class Q2022 {

    @Test
    public void test1() {
        Assert.assertArrayEquals(new int[][]{{1, 2}, {3, 4}}, construct2DArray(new int[]{1, 2, 3, 4}, 2, 2));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[][]{{1, 2, 3}}, construct2DArray(new int[]{1, 2, 3}, 1, 3));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals( new int[][]{{}}, construct2DArray(new int[]{1, 2}, 1, 1));
    }

    @Test
    public void test4() {
        Assert.assertArrayEquals( new int[][]{{}}, construct2DArray(new int[]{3}, 1, 2));
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[][]{};
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[i*n+j];
            }
        }
        return res;
    }
}