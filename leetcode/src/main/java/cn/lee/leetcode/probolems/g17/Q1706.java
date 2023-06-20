package cn.lee.leetcode.probolems.g17;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Title: Q1706
 * @Description: https://leetcode-cn.com/problems/where-will-the-ball-fall/
 * @author: libo
 * @date: 2022/2/24 0024 6:42
 * @Version: 1.0
 */
@Slf4j
public class Q1706 {

    public int[] findBall(int[][] grid) {
        if (grid.length == 0) {
            return new int[]{0};
        }
        int[] res = new int[grid[0].length];
        Arrays.fill(res, -1);
        for (int i = 0; i < res.length; i++) {
            int row = 0, col = i;
            boolean fal = true;
            while (fal && row < grid.length) {
                if (grid[row][col] == 1 && (col == grid[row].length - 1 || grid[row][col + 1] == -1)) {
                    fal = false;
                } else if (grid[row][col] == -1 && (col == 0 || grid[row][col - 1] == 1)) {
                    fal = false;
                } else {
                    if (grid[row][col] == 1) {
                        col++;
                    } else {
                        col--;
                    }
                    row++;
                }
            }
            if (fal) {
                res[i] = col;
            } else {
                res[i] = -1;
            }
        }
        return res;
    }

    @Test
    public void test_1() {
        Assert.assertArrayEquals(new int[]{1,-1,-1,-1,-1}, findBall(new int[][]{{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}}));
    }

    @Test
    public void test_2() {
        Assert.assertArrayEquals(new int[]{-1}, findBall(new int[][]{{-1}}));
    }
    @Test
    public void test_3() {
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4, -1}, findBall(new int[][]{{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}}));
    }
}