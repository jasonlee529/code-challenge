package cn.lee.leetcode.probolems.g0;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q54
 * @Description: https://leetcode-cn.com/problems/spiral-matrix/
 * @author: libo
 * @date: 2021/3/15 9:53
 * @Version: 1.0
 */
@Slf4j
public class Q54 {


	@Test
	public void test1() {
		Assert.assertArrayEquals(new Integer[]{1, 2, 3, 6, 9, 8, 7, 4, 5}, spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}).toArray(new Integer[9]));
	}

	@Test
	public void test2() {
		Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7}, spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}).toArray(new Integer[12]));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<>();
		int h = matrix.length, w = matrix[0].length;
		int[][] pos = new int[h][w];
		int cnt = 0;
		int row = 0, col = 0;
		String direction = "r";//"r d l u
		while (cnt < h * w && pos[row][col] == 0) {
			ans.add(matrix[row][col]);
			pos[row][col] = 1;
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
		return ans;
	}
}
