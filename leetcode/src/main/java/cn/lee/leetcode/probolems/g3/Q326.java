package cn.lee.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q326
 * @Description: https://leetcode-cn.com/problems/power-of-three/
 * @author: libo
 * @date: 2020/10/15 16:14
 * @Version: 1.0
 */
@Slf4j
public class Q326 {
	@Test
	public void test1() {
        Assert.assertFalse(isPowerOfThree(0));
        Assert.assertTrue(isPowerOfThree(1));
        Assert.assertFalse(isPowerOfThree(2));
        Assert.assertTrue(isPowerOfThree(3));
        Assert.assertFalse(isPowerOfThree(4));
        Assert.assertFalse(isPowerOfThree(8888));
        Assert.assertFalse(isPowerOfThree(2147483647));
	}

	public boolean isPowerOfThree(int n) {
		if (n == 0) {
			return false;
		}
		int i = 1;
		while (i > 0 && i < n) {
			i = i * 3;
		}
		return i == n;
	}
}
