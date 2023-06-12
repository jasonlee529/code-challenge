package org.example.leetcode.probolems.g11;

import java.security.PrivateKey;
import java.util.Comparator;
import java.util.PriorityQueue;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q1140
 * @Description: https://leetcode-cn.com/problems/stone-game-ii/
 * @author: libo
 * @date: 2021/9/3 16:36
 * @Version: 1.0
 */
@Slf4j
public class Q1140 {
	@Test
	public void test1() {
		Assert.assertEquals(10, stoneGameII(new int[]{2, 7, 9, 4, 4}));
	}

	public int stoneGameII(int[] piles) {
		int res = 0;
		int M = 1;
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		return res;
	}
}
