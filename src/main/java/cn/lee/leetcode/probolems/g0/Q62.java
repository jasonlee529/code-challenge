package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q62
 * @Description: https://leetcode-cn.com/problems/unique-paths/
 * @author: libo
 * @date: 2020/11/2 9:59
 * @Version: 1.0
 */
@Slf4j
public class Q62 {
    @Test
    public void test() {
//        Assert.assertEquals(3, new Q62().uniquePaths(3, 2));
//        Assert.assertEquals(28, new Q62().uniquePaths(7, 3));
        Assert.assertEquals(1916797311, new Q62().uniquePaths(51, 9));
    }

    int[][] arr = new int[100][100];

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        if (arr[m][n] > 0) {
            return arr[m][n];
        }
        System.out.println(m + " " + n);
        arr[m][n]=uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        return  arr[m][n];
    }
}
