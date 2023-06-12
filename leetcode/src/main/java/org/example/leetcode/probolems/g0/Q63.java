package org.example.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q63
 * @Description: https://leetcode-cn.com/problems/unique-paths-ii/
 * @author: libo
 * @date: 2020/11/2 11:11
 * @Version: 1.0
 */
@Slf4j
public class Q63 {

    @Test
    public void test1() {
        Assert.assertEquals(2, uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, uniquePathsWithObstacles(new int[][]{{0}}));
    }

    @Test
    public void test4() {
        Assert.assertEquals(0, uniquePathsWithObstacles(new int[][]{{1}}));
    }

    @Test
    public void test5() {
        Assert.assertEquals(0, uniquePathsWithObstacles(new int[][]{{1}, {0}}));
    }
    @Test
    public void test6() {
        String a="a",b="b",c="c";
        a=b=c;
        Assert.assertEquals("c", a);
        Assert.assertEquals("c", b);
        Assert.assertEquals("c", c);
        a=b=c=null;
        Assert.assertEquals(null, a);
        Assert.assertEquals(null, b);
        Assert.assertEquals(null, c);
        a=b=null;
        Assert.assertEquals(null, a);
        Assert.assertEquals(null, b);
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] pos = new int[m][n];
        pos[m - 1][0] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[m - i - 1][j] == 1) {
                    pos[i][j] = 0;
                    continue;
                }
                if (i == (m - 1) && j == 0) {
                    continue;
                }
                if (j == 0) {
                    pos[i][j] = pos[i + 1][j];
                } else if (i == (m - 1)) {
                    pos[i][j] = pos[i][j - 1];
                } else {
                    pos[i][j] = pos[i + 1][j] + pos[i][j - 1];
                }
            }
        }
        return pos[0][n - 1];
    }
}
