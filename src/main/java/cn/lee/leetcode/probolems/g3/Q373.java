package cn.lee.leetcode.probolems.g3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javafx.collections.transformation.SortedList;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: Q373
 * @Description: https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 * @author: libo
 * @date: 2022/1/14 13:52
 * @Version: 1.0
 */
@Slf4j
public class Q373 {

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1, o2)->{
			return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
		});
		List<List<Integer>> ans = new ArrayList<>();
		int m = nums1.length;
		int n = nums2.length;
		for (int i = 0; i < Math.min(m, k); i++) {
			pq.offer(new int[]{i,0});
		}
		while (k-- > 0 && !pq.isEmpty()) {
			int[] idxPair = pq.poll();
			List<Integer> list = new ArrayList<>();
			list.add(nums1[idxPair[0]]);
			list.add(nums2[idxPair[1]]);
			ans.add(list);
			if (idxPair[1] + 1 < n) {
				pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
			}
		}

		return ans;
	}


	public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> res = new ArrayList<>();
		for (int n : nums1) {
			for (int m : nums2) {
				List<Integer> r = new ArrayList<>();
				r.add(n);
				r.add(m);
				res.add(r);
			}
		}
		Collections.sort(res, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				return o1.get(0) + o1.get(1) - o2.get(0) - o2.get(1);
			}
		});

		return res.size() > k ? res.subList(0, k) : res;
	}

	@Test
	public void test_1() {
		List<List<Integer>> res = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 4), Arrays.asList(1, 6));
		Assert.assertEquals(res, kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
	}

	@Test
	public void test_2() {
		List<List<Integer>> res = Arrays.asList(Arrays.asList(1, 1), Arrays.asList(1, 1));
		Assert.assertEquals(res, kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
	}

	@Test
	public void test_3() {
		List<List<Integer>> res = Arrays.asList(Arrays.asList(1, 3), Arrays.asList(2, 3));
		Assert.assertEquals(res, kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));
	}
}
