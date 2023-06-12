package org.example.leetcode.probolems.g20;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q2029
 * @Description: https://leetcode-cn.com/problems/stone-game-ix/
 * @author: libo
 * @date: 2022/1/20 16:32
 * @Version: 1.0
 */
@Slf4j
public class Q2029 {


	public boolean stoneGameIX(int[] stones) {
		int cnt0 = 0, cnt1 = 0, cnt2 = 0;
		for (int val : stones) {
			int type = val % 3;
			if (type == 0) {
				++cnt0;
			} else if (type == 1) {
				++cnt1;
			} else {
				++cnt2;
			}
		}
		if (cnt0 % 2 == 0) {
			return cnt1 >= 1 && cnt2 >= 1;
		}
		return cnt1 - cnt2 > 2 || cnt2 - cnt1 > 2;
	}


	@Test
	public void test_1() {
		Assert.assertEquals(true, stoneGameIX(new int[]{2, 1}));
	}

	@Test
	public void test_2() {
		Assert.assertEquals(false, stoneGameIX(new int[]{2}));
	}

	@Test
	public void test_3() {
		Assert.assertEquals(false, stoneGameIX(new int[]{5, 1, 2, 4, 3}));
	}

	@Test
	public void test_4() {
		Assert.assertEquals(true, stoneGameIX(new int[]{1, 1, 7, 10, 8, 17, 10, 20, 2, 10}));
	}

}
