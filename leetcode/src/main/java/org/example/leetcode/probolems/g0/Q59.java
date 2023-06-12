package org.example.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q59
 * @Description: https://leetcode-cn.com/problems/spiral-matrix-ii/
 * @author: libo
 * @date: 2021/3/16 9:02
 * @Version: 1.0
 */
@Slf4j
public class Q59 {

	@Test
	public void test1() {
		Assert.assertArrayEquals(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}, generateMatrix(3));
	}

	@Test
	public void test2() {
		Assert.assertArrayEquals(new int[][]{{1}}, generateMatrix(1));
	}

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int h = matrix.length, w = matrix[0].length;
		int[][] pos = new int[h][w];
		int cnt = 0;
		int row = 0, col = 0;
		String direction = "r";//"r d l u
		while (cnt < h * w && pos[row][col] == 0) {
			pos[row][col] = 1;
			matrix[row][col] = cnt + 1;
			cnt++;
			if ("r".equals(direction)) {
				if (col < w - 1 && pos[row][col + 1] == 0) {
					col++;
				} else {
					direction = "d";
					row++;
				}
			} else if ("d".equals(direction)) {
				if (row < h - 1 && pos[row + 1][col] == 0) {
					row++;
				} else {
					direction = "l";
					col = col - 1 >= 0 ? col - 1 : 0;
				}
			} else if ("l".equals(direction)) {
				if (col > 0 && pos[row][col - 1] == 0) {
					col--;
				} else {
					direction = "u";
					row = row - 1 >= 0 ? row - 1 : 0;
				}
			} else if ("u".equals(direction)) {
				if (row > 0 && pos[row - 1][col] == 0) {
					row--;
				} else {
					direction = "r";
					col++;
				}
			}
		}
		return matrix;
	}
}
