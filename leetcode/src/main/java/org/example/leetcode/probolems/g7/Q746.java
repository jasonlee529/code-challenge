package org.example.leetcode.probolems.g7;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q746
 * @Description: https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * @author: libo
 * @date: 2020/10/30 8:44
 * @Version: 1.0
 */
@Slf4j
public class Q746 {

    @Test
    public void test() {
        System.out.println(new Q746().minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(new Q746().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        Assert.assertEquals(15, new Q746().minCostClimbingStairs(new int[]{10, 15, 20}));
        Assert.assertEquals(15, new Q746().minCostClimbingStairs(new int[]{10, 15, 20}));
        Assert.assertEquals(6, new Q746().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length ];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
