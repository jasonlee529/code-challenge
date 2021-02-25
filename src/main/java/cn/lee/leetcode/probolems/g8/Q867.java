package cn.lee.leetcode.probolems.g8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q867
 * @Description: https://leetcode-cn.com/problems/transpose-matrix/
 * @author: libo
 * @date: 2021/2/25 9:31
 * @Version: 1.0
 */
@Slf4j
public class Q867 {
	@Test
	public void test1() {
		Assert.assertArrayEquals(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}, transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
	}

	@Test
	public void test2() {
		Assert.assertArrayEquals(new int[][]{{1, 4}, {2, 5}, {3, 6}}, transpose(new int[][]{{1, 2, 3}, {4, 5, 6}}));
	}

	public int[][] transpose(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int[][] res = new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[j][i] = matrix[i][j];
			}
		}
		return res;
	}
}
