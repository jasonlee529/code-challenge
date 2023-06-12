package org.example.leetcode.probolems.g0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q90
 * @Description: https://leetcode-cn.com/problems/subsets-ii/
 * @author: libo
 * @date: 2021/3/31 11:12
 * @Version: 1.0
 */
@Slf4j
public class Q90 {


	@Test
	public void test1() {
		Assert.assertEquals(Arrays.deepToString(new int[][]{{}, {1}, {1, 2}, {1, 2, 2}, {2}, {2, 2}}), Arrays.deepToString(subsetsWithDup(new int[]{1, 2, 2}).toArray()));
	}
	@Test
	public void test2() {
		Assert.assertEquals(Arrays.deepToString(new int[][]{{}, {0}}), Arrays.deepToString(subsetsWithDup(new int[]{0}).toArray()));
	}
	@Test
	public void test3() {
		Assert.assertEquals(Arrays.deepToString(new int[][]{{}}), Arrays.deepToString(subsetsWithDup(new int[]{}).toArray()));
	}
	@Test
	public void test4() {
		Assert.assertEquals(Arrays.deepToString(new int[][]{{},{1},{1,4},{1,4,4},{1,4,4,4},{1,4,4,4,4},{4},{4,4},{4,4,4},{4,4,4,4}}), Arrays.deepToString(subsetsWithDup(new int[]{4,4,4,1,4}).toArray()));
	}
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		Stack<Integer> path = new Stack<>();
		List<List<Integer>> res = new ArrayList<>();
		dfs(nums, 0, path, res);
		return res;
	}

	private void dfs(int[] nums, int begin, Stack<Integer> path, List<List<Integer>> res) {
		if(!res.contains(path)){
			res.add(new ArrayList<>(path));
		}
		if (begin >= nums.length) {
			return;
		}
		for (int i = begin; i < nums.length; i++) {
			path.add(nums[i]);
			dfs(nums, i + 1, path, res);
			path.pop();
		}

	}
}
