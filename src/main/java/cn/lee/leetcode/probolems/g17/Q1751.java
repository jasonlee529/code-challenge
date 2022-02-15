package cn.lee.leetcode.probolems.g17;

import java.util.PriorityQueue;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q1751
 * @Description: https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended-ii/
 * @author: libo
 * @date: 2022/2/15 15:34
 * @Version: 1.0
 */
@Slf4j
public class Q1751 {

	public int maxValue(int[][] events, int k) {
		int res = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		Stack<int[]> path = new Stack<>();

		return res;
	}

	@Test
	public void test_1() {
		Assert.assertEquals(7, maxValue(new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 1}}, 2));
	}

	@Test
	public void test_2() {
		Assert.assertEquals(10, maxValue(new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 10}}, 2));
	}

	@Test
	public void test_3() {
		Assert.assertEquals(9, maxValue(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}}, 3));
	}
}
