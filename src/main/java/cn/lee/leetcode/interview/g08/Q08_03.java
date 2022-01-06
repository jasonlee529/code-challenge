package cn.lee.leetcode.interview.g08;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q08_03
 * @Description: https://leetcode-cn.com/problems/magic-index-lcci/
 * @author: libo
 * @date: 2022/1/6 16:12
 * @Version: 1.0
 */
@Slf4j
public class Q08_03 {

	public int findMagicIndex(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == i) {
				return i;
			}
		}
		return -1;
	}

	@Test
	public void test1() {
		Assert.assertEquals(0, findMagicIndex(new int[]{0, 2, 3, 4, 5}));
	}

	@Test
	public void test2() {
		Assert.assertEquals(1, findMagicIndex(new int[]{1, 1, 1}));
	}
}
