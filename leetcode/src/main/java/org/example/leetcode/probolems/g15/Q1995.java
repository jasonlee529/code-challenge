package org.example.leetcode.probolems.g15;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q1995
 * @Description:
 * @author: libo
 * @date: 2021/12/29 11:48
 * @Version: 1.0
 */
@Slf4j
public class Q1995 {

	public int countQuadruplets(int[] nums) {
		Arrays.sort(nums);
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					for (int l = k + 1; l < nums.length; l++) {
						if (nums[i] + nums[j] + nums[k] == nums[l]) {
							res++;
						}
					}
				}
			}
		}
		return res;
	}

	@Test
	public void test1() {
		Assert.assertEquals(1, countQuadruplets(new int[]{1, 2, 3, 6}));
	}

	@Test
	public void test2() {
		Assert.assertEquals(0, countQuadruplets(new int[]{3, 3, 6, 4, 5}));
	}

	@Test
	public void test3() {
		Assert.assertEquals(4, countQuadruplets(new int[]{1, 1, 1, 3, 5}));
	}
}
