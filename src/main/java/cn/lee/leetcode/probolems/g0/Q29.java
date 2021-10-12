package cn.lee.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q29
 * @Description: https://leetcode-cn.com/problems/divide-two-integers/
 * @author: libo
 * @date: 2021/10/12 10:01
 * @Version: 1.0
 */
@Slf4j
public class Q29 {

	@Test
	public void test1() {
		Assert.assertEquals(3, divide(10, 3));
	}

	@Test
	public void test2() {
		Assert.assertEquals(-2, divide(7, -3));
	}

	@Test
	public void test3() {
		Assert.assertEquals(2147483647, divide(-2147483648
				, -1));
	}

	public int divide(int a, int b) {
		int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;
		int LIMIT = -1073741824; // MIN 的一半
		if (a == MIN && b == -1) return MAX;
		boolean flag = false;
		if ((a > 0 && b < 0) || (a < 0 && b > 0)) flag = true;
		if (a > 0) a = -a;
		if (b > 0) b = -b;
		int ans = 0;
		while (a <= b) {
			int c = b, d = -1;
			while (c >= LIMIT && d >= LIMIT && c >= a - c) {
				c += c;
				d += d;
			}
			a -= c;
			ans += d;
		}
		return flag ? ans : -ans;
	}
}
