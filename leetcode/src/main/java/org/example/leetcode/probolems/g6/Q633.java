package org.example.leetcode.probolems.g6;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q633
 * @Description: https://leetcode-cn.com/problems/sum-of-square-numbers/
 * @author: libo
 * @date: 2021/4/28 13:46
 * @Version: 1.0
 */
@Slf4j
public class Q633 {
	@Test
	public void test1() {
		Assert.assertEquals(true,judgeSquareSum(5));
	}

	@Test
	public void test2() {
		Assert.assertEquals(false,judgeSquareSum(3));
	}

	@Test
	public void test3() {
		Assert.assertEquals(true,judgeSquareSum(4));
	}
	public boolean judgeSquareSum(int c) {
		for (long a = 0; a * a <= c; a++) {
			double b = Math.sqrt(c - a * a);
			if (b == (int) b) {
				return true;
			}
		}
		return false;
	}
}
