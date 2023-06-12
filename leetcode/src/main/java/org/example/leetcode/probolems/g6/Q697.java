package org.example.leetcode.probolems.g6;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q697
 * @Description: https://leetcode-cn.com/problems/degree-of-an-array/
 * @author: libo
 * @date: 2021/2/20 9:05
 * @Version: 1.0
 */
@Slf4j
public class Q697 {
	@Test
	public void test1() {
		Assert.assertEquals(2, findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
	}

	@Test
	public void test2() {
		Assert.assertEquals(6, findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
	}

	public int findShortestSubArray(int[] nums) {
		Map<Integer, int[]> map = new HashMap<Integer, int[]>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (map.containsKey(nums[i])) {
				map.get(nums[i])[0]++;
				map.get(nums[i])[2] = i;
			} else {
				map.put(nums[i], new int[]{1, i, i});
			}
		}
		int maxNum = 0, minLen = 0;
		for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
			int[] arr = entry.getValue();
			if (maxNum < arr[0]) {
				maxNum = arr[0];
				minLen = arr[2] - arr[1] + 1;
			} else if (maxNum == arr[0]) {
				if (minLen > arr[2] - arr[1] + 1) {
					minLen = arr[2] - arr[1] + 1;
				}
			}
		}
		return minLen;

	}
}
