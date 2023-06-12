package org.example.leetcode.probolems.g3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q378
 * @Description: https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * @author: libo
 * @date: 2022/2/11 17:40
 * @Version: 1.0
 */
@Slf4j
public class Q378 {

	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2) -> {
			return matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]];
		});
		int ans = matrix[0][0];
		for (int i = 0; i < matrix.length; i++) {
			pq.offer(new int[]{i, 0});
		}
		while (k-- > 0 && !pq.isEmpty()) {
			int[] idxPair = pq.poll();
			int t = matrix[idxPair[0]][idxPair[1]];
			ans = t;
			if (idxPair[1] + 1 < matrix[0].length) {
				pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
			}
		}
		return ans;
	}

	@Test
	public void test_1() {
		Assert.assertEquals(13, kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
	}


	@Test
	public void test_2() {
		Assert.assertEquals(-5, kthSmallest(new int[][]{{-5}}, 1));
	}
}
