package cn.lee.leetcode.probolems.g12;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q1232
 * @Description: https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
 * @author: libo
 * @date: 2021/1/17 11:57
 * @Version: 1.0
 */
@Slf4j
public class Q1232 {
    @Test
    public void test1() {
        Assert.assertEquals(true, checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(false, checkStraightLine(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}));
    }
    @Test
    public void test3() {
        Assert.assertEquals(true, checkStraightLine(new int[][]{{0,0},{0,1},{0,-1}}));
    }
    public boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;

        for (int i = 1; i < len - 1; ++i) {
            int y1 = coordinates[i][1] -coordinates[i-1][1];
            int x1 = coordinates[i][0] -coordinates[i-1][0];
            int y2 = coordinates[i+1][1] -coordinates[i][1];
            int x2 = coordinates[i+1][0] -coordinates[i][0];
            if (y1*x2 != y2*x1) {
                return false;
            }

        }
        return true;
    }
}
