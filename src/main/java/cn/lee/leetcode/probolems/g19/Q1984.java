package cn.lee.leetcode.probolems.g19;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q1984
 * @Description:
 * @author: libo
 * @date: 2022/2/11 10:07
 * @Version: 1.0
 */
@Slf4j
public class Q1984 {


	public int minimumDifference(int[] nums, int k) {
		if (nums.length <= 1) {
			return 0;
		}
		if (k == 1) {
			return 0;
		}
		int res = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + k-1; j < nums.length; j++) {
				res = res < nums[j] - nums[i] ? res : nums[j] - nums[i];
			}
		}
		return res;
	}

	@Test
	public void test_1() {
		Assert.assertEquals(0, minimumDifference(new int[]{90}, 1));
	}

	@Test
	public void test_2() {
		Assert.assertEquals(2, minimumDifference(new int[]{9, 4, 1, 7}, 2));
	}
}
