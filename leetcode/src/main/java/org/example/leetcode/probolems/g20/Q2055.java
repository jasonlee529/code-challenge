package org.example.leetcode.probolems.g20;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q2055
 * @Description: https://leetcode-cn.com/problems/plates-between-candles/
 * @author: libo
 * @date: 2022/3/8 16:36
 * @Version: 1.0
 */
@Slf4j
public class Q2055 {

	public int[] platesBetweenCandles(String s, int[][] queries) {
		int[] res = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int[] q = queries[i];
			int left = findPos(s, q[0], true);
			int right = findPos(s, q[1], false);
			if (left >= right || left == -1 || right == -1) {
				res[i] = 0;
			} else {
				res[i] = count(s, left, right);
			}
		}
		return res;
	}

	private int count(String s, int left, int right) {
		int ans = 0;
		for (int i = left; i < right; i++) {
			if (s.charAt(i) == '*') {
				ans++;
			}
		}
		return ans;
	}

	private int findPos(String s, int begin, boolean b) {
		int pos = -1;
		if (b) {
			for (int i = begin; i < s.length(); i++) {
				if (s.charAt(i) == '|') {
					pos = i;
					break;
				}
			}
		} else {
			for (int i = begin; i >= 0; i--) {
				if (s.charAt(i) == '|') {
					pos = i;
					break;
				}
			}
		}
		return pos;
	}

	@Test
	public void test_1() {
		Assert.assertArrayEquals(new int[]{2, 3}, platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}}));
	}

	@Test
	public void test_2() {
		Assert.assertArrayEquals(new int[]{9, 0, 0, 0, 0}, platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}}));
	}
}
