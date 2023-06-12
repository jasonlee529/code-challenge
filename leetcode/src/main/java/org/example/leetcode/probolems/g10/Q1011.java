package org.example.leetcode.probolems.g10;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q1011
 * @Description: https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 * @author: libo
 * @date: 2021/4/26 17:07
 * @Version: 1.0
 */
@Slf4j
public class Q1011 {
	@Test
	public void test1() {
		Assert.assertEquals(15, shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
	}

	@Test
	public void test2() {
		Assert.assertEquals(6, shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
	}


	public int shipWithinDays(int[] weights, int D) {


		return 0;
	}
}
