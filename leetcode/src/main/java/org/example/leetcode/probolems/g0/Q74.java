package org.example.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q74
 * @Description: https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @author: libo
 * @date: 2021/3/30 9:45
 * @Version: 1.0
 */
@Slf4j
public class Q74 {

	@Test
	public void test1() {
		Assert.assertEquals(true, searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
	}

	@Test
	public void test2() {
		Assert.assertEquals(false, searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		int h = matrix.length, w = matrix[0].length;
		for (int i = 0; i < h; i++) {
			if(matrix[i][0]<=target && matrix[i][w-1]>=target){
				for(int j=0;j<w;j++){
					if(matrix[i][j]==target){
						return true;
					}
				}
			}
		}
		return false;
	}
}
