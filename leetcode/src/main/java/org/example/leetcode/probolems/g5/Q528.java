package org.example.leetcode.probolems.g5;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q528
 * @Description: https://leetcode-cn.com/problems/random-pick-with-weight/
 * @author: libo
 * @date: 2021/8/31 15:18
 * @Version: 1.0
 */
@Slf4j
public class Q528 {
	@Test
	public void test1() {
		Solution solution = new Solution(new int[]{1, 3});
		Assert.assertEquals(1, solution.pickIndex());
	}

	class Solution {

		int[] sum;

		public Solution(int[] w) {
			int n = w.length;
			sum = new int[n + 1];
			for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + w[i - 1];
		}

		public int pickIndex() {
			int n = sum.length;
			int t = (int) (Math.random() * sum[n - 1]) + 1;
			int l = 1, r = n - 1;
			while (l < r) {
				int mid = l + r + 1 >> 1;
				if (sum[mid] < t) l = mid;
				else r = mid - 1;
			}
			return sum[r] < t ? r : r - 1;
		}
	}
}
