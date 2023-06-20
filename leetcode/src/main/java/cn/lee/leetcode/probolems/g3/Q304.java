package cn.lee.leetcode.probolems.g3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q304
 * @Description: https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 * @author: libo
 * @date: 2021/3/2 15:53
 * @Version: 1.0
 */
@Slf4j
public class Q304 {
	@Test
	public void test1() {
		NumMatrix martrix = new NumMatrix(new int[][]{{
				3, 0, 1, 4, 2}, {
				5, 6, 3, 2, 1}, {
				1, 2, 0, 1, 5}, {
				4, 1, 0, 1, 7}, {
				1, 0, 3, 0, 5
		}});
		Assert.assertEquals(8, martrix.sumRegion(2, 1, 4, 3));
	}

	@Test
	public void test2() {
		NumMatrix martrix = new NumMatrix(new int[][]{{
				3, 0, 1, 4, 2}, {
				5, 6, 3, 2, 1}, {
				1, 2, 0, 1, 5}, {
				4, 1, 0, 1, 7}, {
				1, 0, 3, 0, 5
		}});
		Assert.assertEquals(11, martrix.sumRegion(1, 1, 2, 2));
	}

	@Test
	public void test3() {
		NumMatrix martrix = new NumMatrix(new int[][]{{
				3, 0, 1, 4, 2}, {
				5, 6, 3, 2, 1}, {
				1, 2, 0, 1, 5}, {
				4, 1, 0, 1, 7}, {
				1, 0, 3, 0, 5
		}});
		Assert.assertEquals(12, martrix.sumRegion(1, 2, 2, 4));
	}

	class NumMatrix {
		int[][] matrix;

		public NumMatrix(int[][] matrix) {
			this.matrix = matrix;
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			int max = 0;
			for (int i = row1; i <= row2; i++) {
				for (int j = col1; j <= col2; j++) {
					max += matrix[i][j];
				}
			}
			return max;
		}
	}
}

