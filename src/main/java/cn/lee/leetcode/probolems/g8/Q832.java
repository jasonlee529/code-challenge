package cn.lee.leetcode.probolems.g8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q832
 * @Description: https://leetcode-cn.com/problems/flipping-an-image/
 * @author: libo
 * @date: 2021/2/24 13:52
 * @Version: 1.0
 */
@Slf4j
public class Q832 {

	@Test
	public void test1() {
		Assert.assertArrayEquals(new int[][]{{1, 0, 0}, {0, 1, 0}, {1, 1, 1}}, flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}}));
	}

	@Test
	public void test2() {
		Assert.assertArrayEquals(new int[][]{{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}, {1, 0, 1, 0}}, flipAndInvertImage(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}}));
	}

	public int[][] flipAndInvertImage(int[][] A) {
		for (int[] a : A) {
			int len = a.length;
			for (int i = 0; 2 * i < a.length; i++) {
				int t1 = a[i];
				int t2 = a[len - i - 1];
				a[i] = t2 ^ 1;
				a[len - i - 1] = t1 ^ 1;
			}
		}
		return A;
	}
}
