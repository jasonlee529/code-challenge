package cn.lee.leetcode.probolems.g7;

import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q747
 * @Description: https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
 * @author: libo
 * @date: 2022/1/13 10:30
 * @Version: 1.0
 */
@Slf4j
public class Q747 {
	public int dominantIndex(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int index = 0;
		int sMax = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int n = nums[i];
			if (n >= max) {
				max = n;
				index = i;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			int n = nums[i];
			if (n >= sMax && i!=index) {
				sMax=n;
			}
		}
		return max >= 2 * sMax ? index : -1;
	}

	@Test
	public void test1() {
		Assert.assertEquals(1, dominantIndex(new int[]{3, 6, 1, 0}));
	}

	@Test
	public void test2() {
		Assert.assertEquals(-1, dominantIndex(new int[]{1, 2, 3, 4}));
	}

	@Test
	public void test3() {
		Assert.assertEquals(0, dominantIndex(new int[]{1}));
	}

	@Test
	public void test4() {
		Assert.assertEquals(3, dominantIndex(new int[]{0, 0, 0, 1}));
	}

	@Test
	public void test5() {
		Assert.assertEquals(0, dominantIndex(new int[]{1,0}));
	}
	@Test
	public void test6() {
		System.out.println(UUID.randomUUID().toString());
	}
}
