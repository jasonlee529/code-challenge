package org.example.leetcode.probolems.g5;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @Title: Q566
 * @Description: https://leetcode-cn.com/problems/reshape-the-matrix/
 * @author: libo
 * @date: 2020/10/20 15:34
 * @Version: 1.0
 */
@Slf4j
public class Q566 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q566().matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null) {
            return nums;
        }
        if (nums.length * nums[0].length != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        int m = 0, n = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                res[m][n] = nums[i][j];
                if (n + 1 == c) {
                    n = 0;
                    m++;
                } else {
                    n++;
                }
            }
        }
        return res;
    }
}
