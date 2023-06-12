package org.example.leetcode.probolems.g13;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q1380
 * @Description: https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
 * @author: libo
 * @date: 2022/2/15 14:10
 * @Version: 1.0
 */
@Slf4j
public class Q1380 {

	public List<Integer> luckyNumbers(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			int[] pos = new int[]{i, 0};
			int min = matrix[i][0];
			for (int j = 0; j < matrix[i].length; j++) {
				if (min > matrix[i][j]) {
					min = matrix[i][j];
					pos = new int[]{i, j};
				}
			}
			boolean f = true;
			for (int k = 0; k < matrix.length; k++) {
				if (min < matrix[k][pos[1]] && k != pos[0]) {
					f = false;
					break;
				}
			}
			if (f) {
				res.add(min);
			}
		}
		return res;
	}

	@Test
	public void test_1() {
		Assert.assertEquals("[15]", luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}}).toString());
	}

	@Test
	public void test_2() {
		Assert.assertEquals("[12]", luckyNumbers(new int[][]{{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}}).toString());
	}

	@Test
	public void test_3() {
		Assert.assertEquals("[7]", luckyNumbers(new int[][]{{7, 8}, {1, 2}}).toString());
	}
}
