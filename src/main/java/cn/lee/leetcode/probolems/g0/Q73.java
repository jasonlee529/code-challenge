package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q73
 * @Description: https://leetcode-cn.com/problems/set-matrix-zeroes/
 * @author: libo
 * @date: 2021/3/21 0021 19:59
 * @Version: 1.0
 */
@Slf4j
public class Q73 {

    @Test
    public void test1() {
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        Assert.assertArrayEquals(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}, matrix);
    }

    @Test
    public void test2() {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        Assert.assertArrayEquals(new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}}, matrix);
    }

    public void setZeroes(int[][] matrix) {
        int l = matrix.length, w = matrix[0].length;
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                res[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if (res[i][j] == 0) {
                    for (int t = 0; t < l; t++) {
                        matrix[t][j] = 0;
                    }
                    for (int t = 0; t < w; t++) {
                        matrix[i][t] = 0;
                    }
                }
            }
        }
    }
}