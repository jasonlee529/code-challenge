package org.example.leetcode.probolems.g17;

import java.util.Arrays;
import java.util.Comparator;
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

	public int maxValue(int[][] es, int k) {
		int n = es.length;
		int[][] fs = new int[n][k];
		return 0;
	}


	public int maxValue2(int[][] events, int k) {
		int res = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		Stack<int[]> path = new Stack<>();
		dfs(events, 0, k, queue, path);
		return queue.size() == 0 ? 0 : queue.peek();
	}

	private void dfs(int[][] events, int begin, int k, PriorityQueue<Integer> queue, Stack<int[]> path) {
		if (path.size() == k || begin == events.length) {
			queue.offer(sum(path));
			return;
		}
		for (int i = begin; i < events.length; i++) {
			int[] e = events[i];
			boolean can = canJoin(path, e);
			if (can) {
				path.push(e);
			}
			dfs(events, i + 1, k, queue, path);
			if (can) {
				path.pop();
			}
		}
	}

	private boolean canJoin(Stack<int[]> path, int[] e2) {
		boolean can = true;
		for (int[] e : path) {
			if (!(e[0] > e2[1] || e[1] < e2[0])) {
				can = false;
				break;
			}
		}
		return can;
	}

	private Integer sum(Stack<int[]> path) {
		int sum = 0;
		for (int[] e : path) {
			sum += e[2];
		}
		return sum;
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

	@Test
	public void test_4() {
		Assert.assertEquals(9, maxValue(new int[][]{{1, 3, 4}, {2, 4, 1}, {1, 1, 4}, {3, 5, 1}, {2, 5, 5}}, 3));
	}

}
