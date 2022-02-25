package cn.lee.leetcode.offer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q10_2
 * @Description: https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * @author: libo
 * @date: 2022/2/25 10:04
 * @Version: 1.0
 */
@Slf4j
public class Q10_2 {


	public int numWays(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
		}
		return dp[n];
	}

	@Test
	public void test_1() {
		Assert.assertEquals(2, numWays(2));
	}

	@Test
	public void test_2() {
		Assert.assertEquals(21, numWays(7));
	}

	@Test
	public void test_3() {
		Assert.assertEquals(1, numWays(0));
	}
}
