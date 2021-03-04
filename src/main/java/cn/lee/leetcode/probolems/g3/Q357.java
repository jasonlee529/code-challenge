package cn.lee.leetcode.probolems.g3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q357
 * @Description: https://leetcode-cn.com/problems/russian-doll-envelopes/
 * @author: libo
 * @date: 2021/3/4 9:35
 * @Version: 1.0
 */
@Slf4j
public class Q357 {
	@Test
	public void test1() {
		Assert.assertEquals(3, maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
	}

	@Test
	public void test2() {
		Assert.assertEquals(5, maxEnvelopes(new int[][]{{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}}));
	}

	@Test
	public void test3() {
		Assert.assertEquals(3, maxEnvelopes(new int[][]{{46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}}));
	}

	@Test
	public void test4() {
		Assert.assertEquals(2, maxEnvelopes(new int[][]{{10, 8}, {1, 12}, {6, 15}, {2, 18}}));
	}

	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes.length == 0) {
			return 0;
		}

		int n = envelopes.length;
		Arrays.sort(envelopes, new Comparator<int[]>() {
			public int compare(int[] e1, int[] e2) {
				if (e1[0] != e2[0]) {
					return e1[0] - e2[0];
				} else {
					return e2[1] - e1[1];
				}
			}
		});

		int[] f = new int[n];
		Arrays.fill(f, 1);
		int ans = 1;
		for (int i = 1; i < n; ++i) {
			for (int j = 0; j < i; ++j) {
				if (envelopes[j][1] < envelopes[i][1]) {
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
			ans = Math.max(ans, f[i]);
		}
		return ans;
	}

	// DP 动态规划
	public int maxEnvelopes1(int[][] envelopes) {
		List<Integer> arr = new ArrayList<>();
		Deque<int[]> path = new LinkedList<>();
		Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		for (int i = 0; i < envelopes.length; i++) {
			path.add(envelopes[i]);
			dfs(envelopes, i + 1, path, arr);
			path = new LinkedList<>();
		}
		Collections.sort(arr, (a, b) -> {
			return b - a;
		});
		return arr.get(0);
	}

	private void dfs(int[][] envelopes, int begin, Deque<int[]> path, List<Integer> arr) {
		if (begin == envelopes.length) {
			arr.add(path.size());
			return;
		}
		int[] cur = path.size() > 0 ? path.getLast() : null;
		for (int i = begin; i < envelopes.length; i++) {
			int[] lop = envelopes[i];
			if (cur[0] < lop[0] && cur[1] < lop[1]) {
				path.add(lop);
				dfs(envelopes, i + 1, path, arr);
				path.pop();
			}
		}
		arr.add(path.size());
	}

	//第一个不一定能装进去
	public int maxEnvelopes2(int[][] envelopes) {
		if (envelopes == null || envelopes.length < 1) {
			return 0;
		}
		Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		int[] cur = envelopes[0];
		int cnt = 1;
		for (int[] lop : envelopes) {
			if (cur[0] < lop[0] && cur[1] < lop[1]) {
				cur = lop;
				cnt++;
			}
		}
		Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		cur = envelopes[0];
		int cnt2 = 1;
		for (int[] lop : envelopes) {
			if (cur[0] < lop[0] && cur[1] < lop[1]) {
				cur = lop;
				cnt2++;
			}
		}
		return Math.max(cnt, cnt2);
	}


}
