package cn.lee.leetcode.probolems.g10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q1004
 * @Description: https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 * @author: libo
 * @date: 2021/2/19 9:29
 * @Version: 1.0
 */
@Slf4j
public class Q1004 {
	@Test
	public void test1() {
		Assert.assertEquals(6, longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
	}

	@Test
	public void test2() {
		Assert.assertEquals(10, longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
	}

	public int longestOnes(int[] A, int K) {
		int n = A.length;
		int left = 0, lsum = 0, rsum = 0;
		int ans = 0;
		for (int right = 0; right < n; ++right) {
			rsum += 1 - A[right];
			while (lsum < rsum - K) {
				lsum += 1 - A[left];
				++left;
			}
			ans = Math.max(ans, right - left + 1);
		}
		return ans;
	}

	public int longestOnes2(int[] A, int K) {
		List<Integer> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		dfs(A, K, 0, path, res);
		Collections.sort(res, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		return res.size()>0?res.get(0):A.length;
	}

	private void dfs(int[] a, int k, int i, List<Integer> path, List<Integer> res) {
		if (path.size() == k) {
			res.add(count(a));
			return;
		}
		for (int j = i; j < a.length; j++) {
			if (a[j] == 1) {
				continue;
			}
			path.add(j);
			a[j] = 1;
			dfs(a, k, j + 1, path, res);
			path.remove(path.size() - 1);
			a[j] = 0;
		}
	}

	private Integer count(int[] a) {
		int max = 0;
		int c = 0;
		for (int t : a) {
			if (t == 1) {
				c++;
				max = c > max ? c : max;
			} else {
				max = c > max ? c : max;
				c = 0;
			}
		}
		return max;
	}
}
