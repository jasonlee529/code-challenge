package cn.lee.leetcode.weekly.w217;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q5613
 * @Description: https://leetcode-cn.com/problems/richest-customer-wealth/
 * @author: libo
 * @date: 2020/11/29 12:27
 * @Version: 1.0
 */
@Slf4j
public class Q5613 {

    @Test
    public void test() {
        Assert.assertEquals(6, maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
    }

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] arr : accounts) {
            int tmp = 0;
            for (int n : arr) {
                tmp += n;
            }
            max = max > tmp ? max : tmp;
        }
        return max;
    }
}
