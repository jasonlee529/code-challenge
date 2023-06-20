package cn.lee.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q188
 * @Description: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * @author: libo
 * @date: 2020/12/28 13:35
 * @Version: 1.0
 */
@Slf4j
public class Q188 {
    @Test
    public void test1() {
        Assert.assertEquals(2, maxProfit(2, new int[]{2, 4, 1}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(7, maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

    public int maxProfit(int k, int[] prices) {

        return 0;
    }
}
