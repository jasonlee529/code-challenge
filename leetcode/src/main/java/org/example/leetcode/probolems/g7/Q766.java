package org.example.leetcode.probolems.g7;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q766
 * @Description: https://leetcode-cn.com/problems/toeplitz-matrix/
 * @author: libo
 * @date: 2021/2/22 9:39
 * @Version: 1.0
 */
@Slf4j
public class Q766 {
	@Test
	public void test1() {
		Assert.assertEquals(true, isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
	}

	@Test
	public void test2() {
		Assert.assertEquals(false, isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}}));
	}

	@Test
	public void test3() {
		Assert.assertEquals(false, isToeplitzMatrix(new int[][]{{36,59,71,15,26,82,87},{56,36,59,71,15,26,82},{15,0,36,59,71,15,26}}));
	}
	

	public boolean isToeplitzMatrix(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		boolean ok = true;
		for (int i = m - 1; i >= 0; i--) {
			int t = matrix[i][0];
			int a = i, b = 0;
			while (a < m && b < n) {
				ok = t == matrix[a][b];
				a++;
				b++;
				if (!ok) {
					break;
				}
			}

			if (!ok) {
				break;
			}
		}
		for (int i =0; i <n && ok; i++) {
			int t = matrix[0][i];
			int a = 0, b = i;
			while (a < m && b < n) {
				ok = t == matrix[a][b];
				a++;
				b++;
				if (!ok) {
					break;
				}
			}
			if (!ok) {
				break;
			}
		}
		return ok;
	}
}
