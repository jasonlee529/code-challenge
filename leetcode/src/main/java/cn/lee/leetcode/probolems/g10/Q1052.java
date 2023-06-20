package cn.lee.leetcode.probolems.g10;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q1052
 * @Description: https://leetcode-cn.com/problems/grumpy-bookstore-owner/
 * @author: libo
 * @date: 2021/2/23 9:36
 * @Version: 1.0
 */
@Slf4j
public class Q1052 {
	@Test
	public void test1() {
		Assert.assertEquals(16, maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
	}

	@Test
	public void test2() {
		Assert.assertEquals(1, maxSatisfied(new int[]{1}, new int[]{0}, 1));
	}

	@Test
	public void test3() {
		Assert.assertEquals(17, maxSatisfied(new int[]{2, 6, 6, 9}, new int[]{0, 0, 1, 1}, 1));
	}

	@Test
	public void test4() {
		Assert.assertEquals(24, maxSatisfied(new int[]{4, 10, 10}, new int[]{1, 1, 0}, 2));
	}

	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int n = customers.length, sum = 0;
		for (int i = 0; i < X; i++) sum += customers[i] * grumpy[i];

		int res = sum;
		for (int i = X; i < n; i++) {
			sum += customers[i] * grumpy[i] - customers[i - X] * grumpy[i - X];
			res = Math.max(res, sum);
		}

		for (int i = 0; i < n; i++) res += customers[i] * (grumpy[i] ^ 1);
		return res;
	}

	public int maxSatisfied2(int[] customers, int[] grumpy, int X) {
		int max = 0;
		if (X < customers.length) {
			for (int i = 0; i < grumpy.length - X + 1; i++) {
				int t = 0;
				for (int j = 0; j < grumpy.length; j++) {
					int c = grumpy[j];
					if (j >= i && j < i + X) {
						c = 0;
					}
					System.out.println(String.format("{%d},{%d},{%d}", i, j, c));
					t = t + (c == 0 ? customers[j] : 0);
				}
				System.out.println(String.format("{%d},{%d}", i, t));
				max = max > t ? max : t;
			}
		} else {
			for (int n : customers) {
				max += n;
			}
		}
		return max;
	}
}
