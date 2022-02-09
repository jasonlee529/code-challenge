package cn.lee.leetcode.probolems.g20;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q2006
 * @Description: https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k/
 * @author: libo
 * @date: 2022/2/9 13:56
 * @Version: 1.0
 */
@Slf4j
public class Q2006 {

	public int countKDifference(int[] nums, int k) {
		int res = 0;
		for (int i = 0; i < nums.length ; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] - nums[j] == k || nums[i] - nums[j] == -k) {
					res++;
				}
			}
		}
		return res;
	}

	@Test
	public void test_1() {
		Assert.assertEquals(4, countKDifference(new int[]{1, 2, 2, 1}, 1));
	}

	@Test
	public void test_2() {
		Assert.assertEquals(0, countKDifference(new int[]{1, 3}, 3));
	}

	@Test
	public void test_3() {
		Assert.assertEquals(3, countKDifference(new int[]{3, 2, 1, 5, 4}, 2));
	}
}
