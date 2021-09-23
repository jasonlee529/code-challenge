package cn.lee.leetcode.probolems.g9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q986
 * @Description: https://leetcode-cn.com/problems/interval-list-intersections/
 * @author: libo
 * @date: 2021/9/15 13:46
 * @Version: 1.0
 */
@Slf4j
public class Q986 {
	@Test
	public void test1() {
		Assert.assertArrayEquals(new int[][]{{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}},
				intervalIntersection(
						new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
						new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}));
	}

	@Test
	public void test2() {
		Assert.assertArrayEquals(new int[][]{{}},
				intervalIntersection(
						new int[][]{{1, 3}, {5, 9}},
						new int[][]{{}}));
	}

	@Test
	public void test3() {
		Assert.assertArrayEquals(new int[][]{{}},
				intervalIntersection(
						new int[][]{{}},
						new int[][]{{4, 8}, {10, 12}}));
	}

	@Test
	public void test4() {
		Assert.assertArrayEquals(new int[][]{{3, 7}},
				intervalIntersection(
						new int[][]{{1, 7}},
						new int[][]{{3, 10}}));
	}

	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		List<int[]> res = new ArrayList<>();
		for (int[] first : firstList) {
			for (int[] second : secondList) {

			}
		}
		return null;
	}
}
