package cn.lee.leetcode.probolems.g0;

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
        Assert.assertEquals(2, new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, new int[][]{{0, 1}, {0, 0,}});
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


        return 0;
    }
}
