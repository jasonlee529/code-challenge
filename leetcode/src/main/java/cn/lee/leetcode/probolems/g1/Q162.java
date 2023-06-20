package cn.lee.leetcode.probolems.g1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q162
 * @Description: https://leetcode-cn.com/problems/find-peak-element/
 * @author: libo
 * @date: 2021/9/15 11:21
 * @Version: 1.0
 */
@Slf4j
public class Q162 {
	@Test
	public void test1() {
		Assert.assertEquals(2, findPeakElement(new int[]{1, 2, 3, 1}));
	}

	@Test
	public void test2() {
		Assert.assertEquals(1, findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
	}

	public int findPeakElement(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				if (nums[i] > nums[i + 1]) {
					res = i;
					break;
				}
			} else if (i == nums.length - 1) {
				if (nums[i] > nums[i - 1]) {
					res = i;
					break;
				}
			} else if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
				res = i;
				break;
			}
		}
		return res;
	}
}
